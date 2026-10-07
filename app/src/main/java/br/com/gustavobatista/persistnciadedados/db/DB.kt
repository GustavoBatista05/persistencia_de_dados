package br.com.gustavobatista.persistnciadedados.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.gustavobatista.persistnciadedados.dao.PessoaDAO
import br.com.gustavobatista.persistnciadedados.domain.Pessoa

@Database(entities = [Pessoa::class], version = 1)
abstract class DB : RoomDatabase() {

    abstract fun PessoaDAO() : PessoaDAO

    object DatabaseProvider {

        @Volatile
        private var INSTANCE : DB? = null

        fun getDatabase (context: Context) : DB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    DB::class.java,
                    "app_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}