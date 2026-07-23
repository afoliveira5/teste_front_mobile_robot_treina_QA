package com.treinaqa.app.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.treinaqa.app.data.UsuarioEntity
import com.treinaqa.app.ui.seletores.Seletor
import com.treinaqa.app.ui.seletores.Seletores
import com.treinaqa.app.ui.seletores.seletor

@Composable
fun HomeScreen(
    usuario: UsuarioEntity?,
    onAtualizar: () -> Unit,
    onSair: () -> Unit,
    onExcluir: () -> Unit,
    onRefresh: () -> Unit,
) {
    var confirmar by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { onRefresh() }

    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp)
            .seletor(Seletores.paginaDados),
    ) {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text("treinaQA", fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleLarge)
            TextButton(onClick = onSair, modifier = Modifier.seletor(Seletores.botaoSair)) { Text("Sair") }
        }
        Row {
            TextButton(onClick = {}, modifier = Modifier.seletor(Seletores.menuMeusDados)) { Text("Meus Dados") }
            TextButton(onClick = onAtualizar, modifier = Modifier.seletor(Seletores.menuAtualizar)) {
                Text("Atualizar dados")
            }
        }
        Spacer(Modifier.height(12.dp))
        Text("Meus Dados", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(8.dp))

        if (usuario == null) {
            Text("Carregando...")
        } else {
            Info(Seletores.valorNome, "Nome", usuario.nome)
            Info(Seletores.valorEmail, "E-mail", usuario.email)
            Info(Seletores.valorCelular, "Celular", usuario.telefone)
            Info(Seletores.valorCpf, "CPF", usuario.cpf)
            Info(Seletores.valorRua, "Rua", usuario.rua)
            Info(Seletores.valorNumeroCasa, "Número", usuario.numeroCasa)
            Info(Seletores.valorBairro, "Bairro", usuario.bairro)
            Info(Seletores.valorCidade, "Cidade", usuario.cidade)
            Info(Seletores.valorEstado, "Estado", usuario.estado)
        }

        Spacer(Modifier.height(20.dp))
        Button(onClick = onAtualizar, modifier = Modifier.fillMaxWidth().seletor(Seletores.botaoEditar)) {
            Text("Editar")
        }
        Spacer(Modifier.height(8.dp))
        Button(
            onClick = { confirmar = true },
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error),
            modifier = Modifier.fillMaxWidth().seletor(Seletores.botaoExcluirParticipante),
        ) { Text("Excluir participante") }
    }

    if (confirmar) {
        AlertDialog(
            onDismissRequest = { confirmar = false },
            modifier = Modifier.seletor(Seletores.modalConfirmarExclusao),
            title = { Text("Confirmar") },
            text = {
                Text(
                    "Deseja excluir seu cadastro ?",
                    modifier = Modifier.seletor(Seletores.textoModalConfirmarExclusao),
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        confirmar = false
                        onExcluir()
                    },
                    modifier = Modifier.seletor(Seletores.botaoSimExcluir),
                ) { Text("Sim") }
            },
            dismissButton = {
                TextButton(
                    onClick = { confirmar = false },
                    modifier = Modifier.seletor(Seletores.botaoNaoExcluir),
                ) { Text("Não") }
            },
        )
    }
}

@Composable
private fun Info(s: Seletor, label: String, value: String) {
    Text(label, style = MaterialTheme.typography.labelMedium)
    Text(value, modifier = Modifier.seletor(s).padding(bottom = 8.dp))
}
