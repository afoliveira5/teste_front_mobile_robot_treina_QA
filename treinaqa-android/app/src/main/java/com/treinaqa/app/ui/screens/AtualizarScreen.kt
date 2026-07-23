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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
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
import androidx.compose.ui.text.input.KeyboardType
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
import com.treinaqa.app.ui.components.PrimaryActionButton
import com.treinaqa.app.ui.components.TreinaField
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor
import com.treinaqa.app.ui.seletores.seletorCampo
import com.treinaqa.app.ui.seletores.seletorErro
import com.treinaqa.app.ui.theme.TreinaColors
import kotlinx.coroutines.launch

@Composable
fun AtualizarScreen(
    repository: TreinaQaRepository,
    usuario: UsuarioEntity?,
    onVoltar: () -> Unit,
    onSalvo: () -> Unit,
) {
    if (usuario == null) {
        Text("Sem usuário")
        return
    }

    var nome by remember { mutableStateOf(usuario.nome) }
    var email by remember { mutableStateOf(usuario.email) }
    var telefone by remember { mutableStateOf(usuario.telefone) }
    var rua by remember { mutableStateOf(usuario.rua) }
    var numeroCasa by remember { mutableStateOf(usuario.numeroCasa) }
    var bairro by remember { mutableStateOf(usuario.bairro) }
    var cidade by remember { mutableStateOf(usuario.cidade) }
    var estado by remember { mutableStateOf(usuario.estado) }
    var erros by remember { mutableStateOf<Map<String, String>>(emptyMap()) }
    var toast by remember { mutableStateOf<String?>(null) }
    var showOk by remember { mutableStateOf(false) }
    var expandUf by remember { mutableStateOf(false) }
    var tentouEnviar by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val formScroll = rememberScrollState()
    val nomeFocus = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        nomeFocus.requestFocus()
    }

    fun errosAtuais(): Map<String, String> = UsuarioValidators.validarAtualizacao(
        nome, email, telefone, rua, numeroCasa, bairro, cidade, estado,
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
                    "rua" -> rua.isNotBlank()
                    "numeroCasa" -> numeroCasa.isNotBlank()
                    "bairro" -> bairro.isNotBlank()
                    "cidade" -> cidade.isNotBlank()
                    "estado" -> estado.isNotBlank()
                    else -> true
                }
            }
        }
    }

    val formValido by remember {
        derivedStateOf { errosAtuais().isEmpty() }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(TreinaColors.PageBg)
            .seletor(Seletores.paginaAtualizar),
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
                seletor = Seletores.voltarAtualizar,
                modifier = Modifier.align(Alignment.Start),
            )

            Spacer(Modifier.height(12.dp))
            BrandLogo(marcaSeletor = Seletores.tituloMarca)
            Spacer(Modifier.height(20.dp))

            AuthCard(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "Atualizar usuário",
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = TreinaColors.Ink,
                    modifier = Modifier.seletor(Seletores.tituloAtualizar),
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "Todos os campos são obrigatórios. Preencha corretamente para Prosseguir com a Atualização.",
                    color = TreinaColors.InkSoft,
                    fontSize = 13.sp,
                    modifier = Modifier.seletor(Seletores.dicaAtualizar),
                )
                Spacer(Modifier.height(18.dp))

                TreinaField(
                    seletor = Seletores.nomeEdit,
                    label = "Nome",
                    value = nome,
                    onValueChange = { nome = it; toast = null; atualizarErros() },
                    focusRequester = nomeFocus,
                    erro = erros["nome"],
                )
                TreinaField(
                    seletor = Seletores.emailEdit,
                    label = "E-mail",
                    value = email,
                    onValueChange = { email = it; toast = null; atualizarErros() },
                    leadingEmoji = "✉️",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    erro = erros["email"],
                )
                TreinaField(
                    seletor = Seletores.telefoneEdit,
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
                    seletor = Seletores.cpfEdit,
                    label = "CPF",
                    value = usuario.cpf,
                    onValueChange = {},
                    placeholder = "000.000.000-00",
                    readOnly = true,
                    enabled = false,
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
                            .seletor(Seletores.tituloEnderecoAtualizar),
                    )

                    TreinaField(
                        seletor = Seletores.ruaEdit,
                        label = "Nome da rua",
                        value = rua,
                        onValueChange = { rua = it; toast = null; atualizarErros() },
                        erro = erros["rua"],
                    )
                    TreinaField(
                        seletor = Seletores.numeroCasaEdit,
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
                        seletor = Seletores.bairroEdit,
                        label = "Bairro",
                        value = bairro,
                        onValueChange = { bairro = it; toast = null; atualizarErros() },
                        erro = erros["bairro"],
                    )
                    TreinaField(
                        seletor = Seletores.cidadeEdit,
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
                            .seletor(Seletores.labelEstadoAtualizar),
                    )
                    EstadoComboField(
                        seletor = Seletores.estadoEdit,
                        listaSeletor = Seletores.listaEstadosAtualizar,
                        valor = estado,
                        expandido = expandUf,
                        onExpandChange = { expandUf = it },
                        opcoes = UsuarioValidators.ufs,
                        opcaoSeletor = { Seletores.estadoOpcaoAtualizar(it) },
                        onSelecionar = {
                            estado = it
                            expandUf = false
                            toast = null
                            erros = erros - "estado"
                            atualizarErros()
                        },
                        isError = erros["estado"] != null,
                        onDismiss = {
                            if (estado.isBlank()) {
                                erros = erros + ("estado" to "Selecione o estado.")
                            }
                        },
                    )
                    if (erros["estado"] != null) {
                        Text(
                            text = erros["estado"]!!,
                            color = TreinaColors.Danger,
                            fontSize = 12.sp,
                            modifier = Modifier
                                .padding(top = 4.dp)
                                .seletorErro(Seletores.estadoEdit),
                        )
                    }
                }

                if (toast != null) {
                    Spacer(Modifier.height(4.dp))
                    ErrorBanner(message = toast!!, seletor = Seletores.toastAtualizar)
                }
            }

            // Espaço entre o último campo e os botões fixos
            Spacer(Modifier.height(24.dp))
        }

        FormStickyActions(rodapeSeletor = Seletores.rodapeAtualizar) {
            PrimaryActionButton(
                text = "Salvar",
                enabled = formValido,
                seletor = Seletores.botaoSalvar,
                modifier = Modifier.seletorCampo(Seletores.botaoSalvar),
                onClick = {
                    tentouEnviar = true
                    atualizarErros()
                    if (!formValido) {
                        toast = "Há campos inválidos."
                        return@PrimaryActionButton
                    }
                    scope.launch {
                        val atualizado = usuario.copy(
                            nome = nome.trim(),
                            email = email.trim().lowercase(),
                            telefone = telefone,
                            rua = rua.trim(),
                            numeroCasa = numeroCasa.trim(),
                            bairro = bairro.trim(),
                            cidade = cidade.trim(),
                            estado = estado,
                        )
                        repository.atualizar(atualizado, email)
                            .onSuccess { showOk = true }
                            .onFailure {
                                toast = it.message ?: "Não foi possível salvar."
                                if (it.message?.contains("já cadastrado") == true) {
                                    erros = erros + ("email" to "E-mail já cadastrado.")
                                }
                            }
                    }
                },
            )
        }
    }

    if (showOk) {
        AlertDialog(
            onDismissRequest = {},
            modifier = Modifier.seletor(Seletores.modalAtualizarSucesso),
            text = {
                Text(
                    "Dados atualizado com sucesso",
                    modifier = Modifier.seletor(Seletores.textoModalAtualizar),
                )
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showOk = false
                        onSalvo()
                    },
                    modifier = Modifier.seletor(Seletores.botaoOkAtualizar),
                ) { Text("OK") }
            },
        )
    }
}