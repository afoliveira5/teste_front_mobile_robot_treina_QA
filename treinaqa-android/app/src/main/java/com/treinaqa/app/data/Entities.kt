package com.treinaqa.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UsuarioEntity(
    @PrimaryKey val email: String,
    val senha: String,
    val nome: String,
    val telefone: String,
    val cpf: String,
    val rua: String,
    val numeroCasa: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
    val criadoEm: String,
    val atualizadoEm: String? = null,
)

@Entity(tableName = "sessoes")
data class SessaoEntity(
    @PrimaryKey val token: String,
    val usuarioEmail: String,
    val criadoEm: String,
)

@Entity(tableName = "recuperacoes")
data class RecuperacaoEntity(
    @PrimaryKey val id: String,
    val email: String,
    val solicitadoEm: String,
)
