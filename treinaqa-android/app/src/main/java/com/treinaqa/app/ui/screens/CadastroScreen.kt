package com.treinaqa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treinaqa.app.data.TreinaQaRepository
import com.treinaqa.app.data.UsuarioEntity
import com.treinaqa.app.domain.Mascaras
import com.treinaqa.app.domain.UsuarioValidators
import com.treinaqa.app.ui.components.AuthCard
import com.treinaqa.app.ui.components.BackButton
import com.treinaqa.app.ui.components.BrandLogo
import com.treinaqa.app.ui.components.ErrorBanner
import com.treinaqa.app.ui.components.EstadoComboField
import com.treinaqa.app.ui.components.FormStickyActions
import com.treinaqa.app.ui.components.PasswordTrailing
import com.treinaqa.app.ui.components.PrimaryActionButton
import com.treinaqa.app.ui.components.TreinaField
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor
import com.treinaqa.app.ui.seletores.seletorErro
import com.treinaqa.app.ui.theme.TreinaColors
import kotlinx.coroutines.launch
import java.time.Instant

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CadastroScreen(
    repository: TreinaQaRepository,
    onVoltar: () -> Unit,
    onSucesso: () -> Unit,
) {
    var nome by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var cpf by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }
    var numeroCasa by remember { mutableStateOf("") }
    var bairro by remember { mutableStateOf("") }
    var cidade by remember { mutableStateOf("") }
    var estado by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var showSenha by remember { mutableStateOf(false) }
    var erros by remember { mutableStateOf<Map<String, String>>(emptyMap()) }
    var toast by remember { mutableStateOf<String?>(null) }
    var showModal by remember { mutableStateOf(false) }
    var expandUf by remember { mutableStateOf(false) }
    var tentouEnviar by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val formScroll = rememberScrollState()
    val nomeFocus = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        nomeFocus.requestFocus()
    }

    fun errosAtuais(): Map<String, String> = UsuarioValidators.validarCadastro(
        nome, email, telefone, cpf, rua, numeroCasa, bairro, cidade, estado, senha,
    )

    fun atualizarErros() {
        val all = errosAtuais()
        erros = if (tentouEnviar) {
            all
        } else {
            all.filterKeys { key ->
                when (key) {
                    "nome" -> nome.isNotBlank()
                    "email" -> email.isNotBlank()
                    "telefone" -> telefone.isNotBlank()
                    "cpf" -> cpf.isNotBlank()
                    "rua" -> rua.isNotBlank()
                    "numeroCasa" -> numeroCasa.isNotBlank()
                    "bairro" -> bairro.isNotBlank()
                    "cidade" -> cidade.isNotBlank()
                    "estado" -> estado.isNotBlank()
                    "senha" -> senha.isNotBlank()
                    else -> true
                }
            }
        }
    }

    val formValido by remember {
        derivedStateOf { errosAtuais().isEmpty() }
    }

    fun tentarCadastrar() {
        tentouEnviar = true
        atualizarErros()
        if (!formValido) {
            toast = "Há campos inválidos."
            return
        }
        scope.launch {
            val agora = Instant.now().toString()
            val r = repository.cadastrar(
                UsuarioEntity(
                    email = email,
                    senha = senha,
                    nome = nome.trim(),
                    telefone = telefone,
                    cpf = cpf,
                    rua = rua.trim(),
                    numeroCasa = numeroCasa.trim(),
                    bairro = bairro.trim(),
                    cidade = cidade.trim(),
                    estado = estado,
                    criadoEm = agora,
                ),
            )
            r.onSuccess { showModal = true }
                .onFailure {
                    toast = it.message
                    if (it.message?.contains("já cadastrado") == true) {
                        erros = erros + ("email" to "E-mail já cadastrado.")
                    }
                }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TreinaColors.PageBg)
            .seletor(Seletores.paginaCadastro),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(formScroll)
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BackButton(
                onClick = onVoltar,
                seletor = Seletores.voltarCadastro,
                modifier = Modifier.align(Alignment.Start),
            )

            Spacer(Modifier.height(12.dp))
            BrandLogo(marcaSeletor = Seletores.tituloMarca)
            Spacer(Modifier.height(20.dp))

            AuthCard(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Cadastro de usuário",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = TreinaColors.Ink,
                    modifier = Modifier.seletor(Seletores.tituloCadastro),
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Todos os campos são obrigatórios. Preencha corretamente para Prosseguir com o Cadastro.",
                    color = TreinaColors.InkSoft,
                    fontSize = 13.sp,
                    modifier = Modifier.seletor(Seletores.dicaCadastro),
                )
                Spacer(Modifier.height(18.dp))

                TreinaField(
                    seletor = Seletores.nome,
                    label = "Nome",
                    value = nome,
                    onValueChange = { nome = it; toast = null; atualizarErros() },
                    focusRequester = nomeFocus,
                    erro = erros["nome"],
                )
                TreinaField(
                    seletor = Seletores.emailCadastro,
                    label = "E-mail",
                    value = email,
                    onValueChange = { email = it; toast = null; atualizarErros() },
                    leadingEmoji = "✉️",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    erro = erros["email"],
                )
                TreinaField(
                    seletor = Seletores.telefoneCadastro,
                    label = "Celular",
                    value = telefone,
                    onValueChange = {
                        telefone = Mascaras.celular(it)
                        toast = null
                        atualizarErros()
                    },
                    placeholder = "+55 (00) 00000-0000",
                    leadingEmoji = "📱",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    erro = erros["telefone"],
                )
                TreinaField(
                    seletor = Seletores.cpfCadastro,
                    label = "CPF",
                    value = cpf,
                    onValueChange = {
                        cpf = Mascaras.cpf(it)
                        toast = null
                        atualizarErros()
                    },
                    placeholder = "000.000.000-00",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    erro = erros["cpf"],
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .border(1.dp, TreinaColors.Line, RoundedCornerShape(12.dp))
                        .padding(14.dp),
                ) {
                    Text(
                        text = "Endereço",
                        fontWeight = FontWeight.Bold,
                        color = TreinaColors.Ink,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(bottom = 10.dp)
                            .seletor(Seletores.tituloEnderecoCadastro),
                    )

                    TreinaField(
                        seletor = Seletores.ruaCadastro,
                        label = "Nome da rua",
                        value = rua,
                        onValueChange = { rua = it; toast = null; atualizarErros() },
                        erro = erros["rua"],
                    )
                    TreinaField(
                        seletor = Seletores.numeroCasaCadastro,
                        label = "Número da casa",
                        value = numeroCasa,
                        onValueChange = {
                            numeroCasa = Mascaras.numeroCasa(it)
                            toast = null
                            atualizarErros()
                        },
                        erro = erros["numeroCasa"],
                    )
                    TreinaField(
                        seletor = Seletores.bairroCadastro,
                        label = "Bairro",
                        value = bairro,
                        onValueChange = { bairro = it; toast = null; atualizarErros() },
                        erro = erros["bairro"],
                    )
                    TreinaField(
                        seletor = Seletores.cidadeCadastro,
                        label = "Cidade",
                        value = cidade,
                        onValueChange = { cidade = it; toast = null; atualizarErros() },
                        erro = erros["cidade"],
                    )

                    Text(
                        text = "Estado",
                        fontWeight = FontWeight.Bold,
                        color = TreinaColors.Ink,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .padding(bottom = 6.dp)
                            .seletor(Seletores.labelEstadoCadastro),
                    )
                    EstadoComboField(
                        seletor = Seletores.estadoCadastro,
                        listaSeletor = Seletores.listaEstados,
                        valor = estado,
                        expandido = expandUf,
                        onExpandChange = { expandUf = it },
                        opcoes = UsuarioValidators.ufs,
                        opcaoSeletor = { Seletores.estadoOpcao(it) },
                        onSelecionar = {
                            estado = it
                            expandUf = false
                            toast = null
                            atualizarErros()
                        },
                        isError = erros["estado"] != null,
                    )
                    if (erros["estado"] != null) {
                        Text(
                            text = erros["estado"]!!,
                            color = TreinaColors.Danger,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .seletorErro(Seletores.estadoCadastro),
                        )
                    }
                }

                TreinaField(
                    seletor = Seletores.senha,
                    label = "Senha",
                    value = senha,
                    onValueChange = { senha = it; toast = null; atualizarErros() },
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
                            seletor = Seletores.olhoSenhaCadastro,
                            visibleIcon = Icons.Default.VisibilityOff,
                            hiddenIcon = Icons.Default.Visibility,
                        )
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = { tentarCadastrar() },
                    ),
                    erro = erros["senha"],
                )

                if (toast != null) {
                    Spacer(Modifier.height(4.dp))
                    ErrorBanner(message = toast!!, seletor = Seletores.toastCadastro)
                }
            }

            // Espaço entre o último campo e o botão fixo
            Spacer(Modifier.height(24.dp))
        }

        FormStickyActions(rodapeSeletor = Seletores.rodapeCadastro) {
            PrimaryActionButton(
                text = "Cadastrar",
                enabled = formValido,
                seletor = Seletores.botaoCadastrar,
                modifier = Modifier.seletor(Seletores.botaoCadastrar),
                onClick = { tentarCadastrar() },
            )
        }
    }

    if (showModal) {
        AlertDialog(
            onDismissRequest = {},
            modifier = Modifier.seletor(Seletores.modalCadastroSucesso),
            title = { Text("Parabéns!") },
            text = { Text("Cadastro realizado com sucesso.") },
            confirmButton = {
                TextButton(
                    onClick = {
                        scope.launch {
                            repository.login(email.trim().lowercase(), senha)
                            showModal = false
                            onSucesso()
                        }
                    },
                    modifier = Modifier.seletor(Seletores.botaoOkCadastro),
                ) { Text("OK") }
            },
        )
    }
}
