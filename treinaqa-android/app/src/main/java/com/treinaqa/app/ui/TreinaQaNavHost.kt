package com.treinaqa.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.treinaqa.app.data.TreinaQaRepository
import com.treinaqa.app.data.UsuarioEntity
import com.treinaqa.app.ui.screens.AtualizarScreen
import com.treinaqa.app.ui.screens.CadastroScreen
import com.treinaqa.app.ui.screens.EsqueciSenhaScreen
import com.treinaqa.app.ui.screens.HomeScreen
import com.treinaqa.app.ui.screens.LoginScreen
import kotlinx.coroutines.launch

object Routes {
    const val Login = "login"
    const val Cadastro = "cadastro"
    const val Esqueci = "esqueci"
    const val Home = "home"
    const val Atualizar = "atualizar"
}

@Composable
fun TreinaQaNavHost(repository: TreinaQaRepository) {
    val nav = rememberNavController()
    val scope = rememberCoroutineScope()
    var usuario by remember { mutableStateOf<UsuarioEntity?>(null) }
    var start by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        usuario = repository.usuarioLogado()
        start = if (usuario != null) Routes.Home else Routes.Login
    }

    if (start == null) return

    NavHost(navController = nav, startDestination = start!!) {
        composable(Routes.Login) {
            LoginScreen(
                repository = repository,
                onLoginOk = {
                    scope.launch {
                        usuario = repository.usuarioLogado()
                        nav.navigate(Routes.Home) {
                            popUpTo(Routes.Login) { inclusive = true }
                        }
                    }
                },
                onCadastro = { nav.navigate(Routes.Cadastro) },
                onEsqueci = { nav.navigate(Routes.Esqueci) },
            )
        }
        composable(Routes.Cadastro) {
            CadastroScreen(
                repository = repository,
                onVoltar = { nav.popBackStack() },
                onSucesso = {
                    scope.launch {
                        usuario = repository.usuarioLogado()
                        nav.navigate(Routes.Home) {
                            popUpTo(Routes.Login) { inclusive = true }
                        }
                    }
                },
            )
        }
        composable(Routes.Esqueci) {
            EsqueciSenhaScreen(
                repository = repository,
                onVoltar = { nav.popBackStack() },
            )
        }
        composable(Routes.Home) {
            HomeScreen(
                usuario = usuario,
                onAtualizar = { nav.navigate(Routes.Atualizar) },
                onSair = {
                    scope.launch {
                        repository.logout()
                        usuario = null
                        nav.navigate(Routes.Login) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                },
                onExcluir = {
                    scope.launch {
                        repository.excluirConta()
                        usuario = null
                        nav.navigate(Routes.Login) {
                            popUpTo(0) { inclusive = true }
                        }
                    }
                },
                onRefresh = {
                    scope.launch { usuario = repository.usuarioLogado() }
                },
            )
        }
        composable(Routes.Atualizar) {
            AtualizarScreen(
                repository = repository,
                usuario = usuario,
                onVoltar = { nav.popBackStack() },
                onSalvo = {
                    scope.launch {
                        usuario = repository.usuarioLogado()
                        nav.popBackStack()
                    }
                },
            )
        }
    }
}
