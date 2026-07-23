package com.treinaqa.app.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.treinaqa.app.data.TreinaQaRepository
import com.treinaqa.app.ui.components.AuthCard
import com.treinaqa.app.ui.components.BackButton
import com.treinaqa.app.ui.components.BrandLogo
import com.treinaqa.app.ui.components.ErrorBanner
import com.treinaqa.app.ui.components.PrimaryActionButton
import com.treinaqa.app.ui.components.SafeBottomFooter
import com.treinaqa.app.ui.components.TreinaField
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor
import com.treinaqa.app.ui.theme.TreinaColors
import kotlinx.coroutines.launch

@Composable
fun EsqueciSenhaScreen(
    repository: TreinaQaRepository,
    onVoltar: () -> Unit,
) {
    var email by remember { mutableStateOf("") }
    var msg by remember { mutableStateOf<String?>(null) }
    var erro by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TreinaColors.PageBg)
            .seletor(Seletores.paginaEsqueci),
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
                .padding(top = 20.dp, bottom = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            BackButton(
                onClick = onVoltar,
                seletor = Seletores.voltarEsqueci,
                modifier = Modifier.align(Alignment.Start),
            )

            Spacer(Modifier.height(12.dp))
            BrandLogo(subtitle = "Recupere o acesso à sua conta.")
            Spacer(Modifier.height(20.dp))

            AuthCard(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Esqueci a senha",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = TreinaColors.Ink,
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Informe o e-mail cadastrado para receber a recuperação.",
                    color = TreinaColors.InkSoft,
                    fontSize = 13.sp,
                )
                Spacer(Modifier.height(18.dp))

                TreinaField(
                    seletor = Seletores.emailRecuperacao,
                    label = "E-mail",
                    value = email,
                    onValueChange = { email = it; msg = null },
                    leadingEmoji = "✉️",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                )

                if (msg != null) {
                    Spacer(Modifier.height(4.dp))
                    if (erro) {
                        ErrorBanner(message = msg!!, seletor = Seletores.toastEsqueciSenha)
                    } else {
                        Text(
                            text = msg!!,
                            color = TreinaColors.Ink,
                            fontWeight = FontWeight.Medium,
                            fontSize = 14.sp,
                            modifier = Modifier.seletor(Seletores.toastEsqueciSenha),
                        )
                    }
                }

                Spacer(Modifier.height(12.dp))
                PrimaryActionButton(
                    text = "Enviar",
                    seletor = Seletores.botaoEnviarRecuperacao,
                    onClick = {
                        scope.launch {
                            val r = repository.recuperarSenha(email)
                            erro = r.isFailure
                            msg = r.exceptionOrNull()?.message ?: r.getOrNull()
                        }
                    },
                )
            }
        }

        SafeBottomFooter()
    }
}
