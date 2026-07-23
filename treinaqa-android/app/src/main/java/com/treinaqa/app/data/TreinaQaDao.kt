package com.treinaqa.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TreinaQaDao {
    @Query("SELECT * FROM usuarios WHERE email = :email LIMIT 1")
    suspend fun getUsuario(email: String): UsuarioEntity?

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUsuario(usuario: UsuarioEntity)

    @Update
    suspend fun updateUsuario(usuario: UsuarioEntity)

    @Query("DELETE FROM usuarios WHERE email = :email")
    suspend fun deleteUsuario(email: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSessao(sessao: SessaoEntity)

    @Query("SELECT * FROM sessoes WHERE token = :token LIMIT 1")
    suspend fun getSessao(token: String): SessaoEntity?

    @Query("DELETE FROM sessoes WHERE token = :token")
    suspend fun deleteSessao(token: String)

    @Query("DELETE FROM sessoes WHERE usuarioEmail = :email")
    suspend fun deleteSessoesDoUsuario(email: String)

    @Insert
    suspend fun insertRecuperacao(item: RecuperacaoEntity)

    @Query("SELECT COUNT(*) FROM usuarios")
    suspend fun countUsuarios(): Int
}
