package com.treinaqa.app.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.Instant

@Database(
    entities = [UsuarioEntity::class, SessaoEntity::class, RecuperacaoEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class TreinaQaDatabase : RoomDatabase() {
    abstract fun dao(): TreinaQaDao

    companion object {
        @Volatile private var instance: TreinaQaDatabase? = null

        fun get(context: Context): TreinaQaDatabase =
            instance ?: synchronized(this) {
                instance ?: Room.databaseBuilder(
                    context.applicationContext,
                    TreinaQaDatabase::class.java,
                    "treinaqa.db",
                )
                    .addCallback(
                        object : Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                super.onCreate(db)
                                CoroutineScope(Dispatchers.IO).launch {
                                    get(context).dao().let { dao ->
                                        if (dao.countUsuarios() == 0) {
                                            val agora = Instant.now().toString()
                                            dao.insertUsuario(
                                                UsuarioEntity(
                                                    email = "teste@gmail.com",
                                                    senha = "Test@mobi2024",
                                                    nome = "Teste Aparecido Silva",
                                                    telefone = "5588996442249",
                                                    cpf = "37082030894",
                                                    rua = "Rua Manduca Nogueira",
                                                    numeroCasa = "18A",
                                                    bairro = "Novo Horizonte Sul",
                                                    cidade = "Lavras da Mangabeira",
                                                    estado = "CE",
                                                    criadoEm = agora,
                                                ),
                                            )
                                            dao.insertUsuario(
                                                UsuarioEntity(
                                                    email = "ana.souza@gmail.com",
                                                    senha = "123456",
                                                    nome = "Ana Souza",
                                                    telefone = "5588996442249",
                                                    cpf = "12345678909",
                                                    rua = "Rua das Flores",
                                                    numeroCasa = "120A",
                                                    bairro = "Alto da Gloria",
                                                    cidade = "Sao Paulo",
                                                    estado = "SP",
                                                    criadoEm = agora,
                                                ),
                                            )
                                        }
                                    }
                                }
                            }
                        },
                    )
                    .build()
                    .also { instance = it }
            }
    }
}
