package com.treinaqa.app.data

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.util.UUID

private val Context.dataStore by preferencesDataStore("treinaqa_prefs")

class TreinaQaRepository(context: Context) {
    private val appContext = context.applicationContext
    private val dao = TreinaQaDatabase.get(appContext).dao()

    private val keyToken = stringPreferencesKey("treinaqa_token")
    private val keyUltimoEmail = stringPreferencesKey("treinaqa_ultimo_email")

    val tokenFlow: Flow<String?> = appContext.dataStore.data.map { it[keyToken] }

    suspend fun getToken(): String? = appContext.dataStore.data.first()[keyToken]

    suspend fun getUltimoEmail(): String? = appContext.dataStore.data.first()[keyUltimoEmail]

    private suspend fun salvarToken(token: String?, email: String?) {
        appContext.dataStore.edit { prefs ->
            if (token == null) prefs.remove(keyToken) else prefs[keyToken] = token
            if (email != null) prefs[keyUltimoEmail] = email
        }
    }

    suspend fun login(email: String, senha: String): Result<UsuarioEntity> {
        val chave = email.trim().lowercase()
        if (chave.isBlank() || senha.isBlank()) {
            return Result.failure(Exception("Preencha e-mail e senha."))
        }
        val user = dao.getUsuario(chave)
            ?: return Result.failure(Exception("E-mail ou senha inválidos."))
        if (user.senha != senha) {
            return Result.failure(Exception("E-mail ou senha inválidos."))
        }
        val token = UUID.randomUUID().toString()
        dao.insertSessao(SessaoEntity(token, chave, Instant.now().toString()))
        salvarToken(token, chave)
        return Result.success(user)
    }

    suspend fun logout() {
        getToken()?.let { dao.deleteSessao(it) }
        salvarToken(null, null)
    }

    suspend fun cadastrar(dados: UsuarioEntity): Result<UsuarioEntity> {
        val email = dados.email.trim().lowercase()
        if (dao.getUsuario(email) != null) {
            return Result.failure(Exception("E-mail já cadastrado."))
        }
        val agora = Instant.now().toString()
        val user = dados.copy(
            email = email,
            telefone = UsuarioEntityDigits.only(dados.telefone),
            cpf = UsuarioEntityDigits.only(dados.cpf),
            numeroCasa = dados.numeroCasa.trim().uppercase(),
            estado = dados.estado.trim().uppercase(),
            criadoEm = agora,
        )
        dao.insertUsuario(user)
        return Result.success(user)
    }

    suspend fun usuarioLogado(): UsuarioEntity? {
        val token = getToken() ?: return null
        val sessao = dao.getSessao(token) ?: return null
        return dao.getUsuario(sessao.usuarioEmail)
    }

    suspend fun atualizar(atual: UsuarioEntity, novoEmail: String): Result<UsuarioEntity> {
        val emailNovo = novoEmail.trim().lowercase()
        val emailAntigo = atual.email
        if (emailNovo != emailAntigo && dao.getUsuario(emailNovo) != null) {
            return Result.failure(Exception("E-mail já cadastrado."))
        }
        val agora = Instant.now().toString()
        val atualizado = atual.copy(
            email = emailNovo,
            telefone = UsuarioEntityDigits.only(atual.telefone),
            numeroCasa = atual.numeroCasa.trim().uppercase(),
            estado = atual.estado.trim().uppercase(),
            atualizadoEm = agora,
        )
        if (emailNovo != emailAntigo) {
            dao.deleteUsuario(emailAntigo)
            dao.insertUsuario(atualizado)
            dao.deleteSessoesDoUsuario(emailAntigo)
            val token = UUID.randomUUID().toString()
            dao.insertSessao(SessaoEntity(token, emailNovo, agora))
            salvarToken(token, emailNovo)
        } else {
            dao.updateUsuario(atualizado)
        }
        return Result.success(atualizado)
    }

    suspend fun excluirConta(): Result<Unit> {
        val user = usuarioLogado() ?: return Result.failure(Exception("Sessão inválida. Faça login."))
        dao.deleteSessoesDoUsuario(user.email)
        dao.deleteUsuario(user.email)
        salvarToken(null, null)
        return Result.success(Unit)
    }

    suspend fun recuperarSenha(email: String): Result<String> {
        val e = email.trim().lowercase()
        if (e.isEmpty() || !e.contains("@")) {
            return Result.failure(Exception("Informe um e-mail válido."))
        }
        dao.insertRecuperacao(
            RecuperacaoEntity(UUID.randomUUID().toString(), e, Instant.now().toString()),
        )
        return Result.success("Se o e-mail existir, enviaremos as instruções. (simulado)")
    }
}

private object UsuarioEntityDigits {
    fun only(v: String) = v.replace(Regex("\\D"), "")
}
