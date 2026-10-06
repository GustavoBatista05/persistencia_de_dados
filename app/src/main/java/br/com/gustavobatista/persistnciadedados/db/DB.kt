package br.com.gustavobatista.persistnciadedados.db

import android.content.Context

abstract class DB {

    object DatabaseProvider {

        @Volatile
        private var INSTANCE : DB? = null

        fun getDatabase (context: Context) : DB {


            return
        }
    }
}