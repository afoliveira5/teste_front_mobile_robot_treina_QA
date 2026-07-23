package com.treinaqa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treinaqa.app.data.TreinaQaRepository
import com.treinaqa.app.ui.components.AuthCard
import com.treinaqa.app.ui.components.BrandLogo
import com.treinaqa.app.ui.components.ErrorBanner
import com.treinaqa.app.ui.components.LinkTextButton
import com.treinaqa.app.ui.components.OutlineActionButton
import com.treinaqa.app.ui.components.PasswordTrailing
import com.treinaqa.app.ui.components.SafeBottomFooter
import com.treinaqa.app.ui.components.TreinaField
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor
import com.treinaqa.app.ui.theme.TreinaColors
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    repository: TreinaQaRepository,
    onLoginOk: () -> Unit,
    onCadastro: () -> Unit,
    onEsqueci: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var showSenha by remember { mutableStateOf(false) }
    var erroEmail by remember { mutableStateOf<String?>(null) }
    var erroSenha by remember { mutableStateOf<String?>(null) }
    var toast by remember { mutableStateOf<String?>(null) }
    var loading by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val focusManager = LocalFocusManager.current
    val keyboard = LocalSoftwareKeyboardController.current

    LaunchedEffect(Unit) {
        email = repository.getUltimoEmail().orEmpty()
    }

    fun limparErrosCampos() {
        erroEmail = null
        erroSenha = null
        toast = null
    }

    fun validarCamposLogin(): Boolean {
        val emailVazio = email.isBlank()
        val senhaVazia = senha.isBlank()
        when {
            emailVazio && senhaVazia -> {
                erroEmail = "Preencha o e-mail."
                erroSenha = "Preencha a senha."
                toast = "Preencha e-mail e senha."
            }
            emailVazio -> {
                erroEmail = "Preencha o e-mail."
                erroSenha = null
                toast = "Preencha o e-mail."
            }
            senhaVazia -> {
                erroEmail = null
                erroSenha = "Preencha a senha."
                toast = "Preencha a senha."
            }
            else -> {
                erroEmail = null
                erroSenha = null
                toast = null
                return true
            }
        }
        return false
    }

    fun tentarLogin() {
        if (loading) return
        if (!validarCamposLogin()) return
        keyboard?.hide()
        focusManager.clearFocus()
        loading = true
        scope.launch {
            val r = repository.login(email, senha)
            loading = false
            r.onSuccess {
                limparErrosCampos()
                onLoginOk()
            }.onFailure {
                val msg = it.message ?: "E-mail ou senha inválidos."
                toast = msg
                erroEmail = msg
                erroSenha = msg
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(TreinaColors.PageBg)
            .seletor(Seletores.paginaLogin),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(top = 28.dp, bottom = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                BrandLogo(
                    subtitle = "Portal de treino para automação de testes.",
                    subtitleTag = Seletores.subtituloLogin,
                )
                Spacer(Modifier.height(28.dp))

                AuthCard {
                    Text(
                        text = "Acesso",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        color = TreinaColors.Ink,
                        modifier = Modifier.seletor(Seletores.tituloLogin),
                    )
                    Spacer(Modifier.height(6.dp))
                    Text(
                        text = "Entre na sua conta ou crie uma nova.",
                        color = TreinaColors.InkSoft,
                        fontSize = 14.sp,
                        modifier = Modifier.seletor(Seletores.dicaLogin),
                    )
                    Spacer(Modifier.height(20.dp))

                    TreinaField(
                        seletor = Seletores.loginEmail,
                        label = "E-mail",
                        value = email,
                        onValueChange = {
                            email = it
                            erroEmail = null
                            toast = null
                        },
                        leadingEmoji = "✉️",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Email,
                            imeAction = ImeAction.Next,
                        ),
                        erro = erroEmail,
                    )

                    TreinaField(
                        seletor = Seletores.loginSenha,
                        label = "Senha",
                        value = senha,
                        onValueChange = {
                            senha = it
                            erroSenha = null
                            toast = null
                        },
                        placeholder = "Digite sua senha",
                        leadingEmoji = "🔒",
                        visualTransformation = if (showSenha) {
                            VisualTransformation.None
                        } else {
                            PasswordVisualTransformation()
                        },
                        trailing = {
                            PasswordTrailing(
                                visible = showSenha,
                                enabled = senha.isNotEmpty(),
                                onToggle = { showSenha = !showSenha },
                                seletor = Seletores.olhoLoginSenha,
                                visibleIcon = Icons.Default.VisibilityOff,
                                hiddenIcon = Icons.Default.Visibility,
                            )
                        },
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password,
                            imeAction = ImeAction.Done,
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { tentarLogin() },
                        ),
                        erro = erroSenha,
                    )

                    Spacer(Modifier.height(8.dp))
                    OutlineActionButton(
                        text = "Criar conta",
                        onClick = onCadastro,
                        seletor = Seletores.linkCadastro,
                    )
                    Spacer(Modifier.height(10.dp))
                    OutlineActionButton(
                        text = if (loading) "Entrando..." else "Entrar na conta",
                        onClick = { tentarLogin() },
                        enabled = !loading,
                        seletor = Seletores.botaoEntrar,
                    )

                    Spacer(Modifier.height(4.dp))
                    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                        LinkTextButton(
                            text = "Esqueci a senha",
                            onClick = onEsqueci,
                            seletor = Seletores.linkEsqueciSenha,
                        )
                    }

                    if (toast != null) {
                        Spacer(Modifier.height(8.dp))
                        ErrorBanner(message = toast!!, seletor = Seletores.toastLogin)
                    }
                }
            }

            SafeBottomFooter()
        }
    }
}
