package br.com.gustavobatista.persistnciadedados.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pessoa")
data class Pessoa {
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0
    var nome : String = ""
    var idade : Int = 0
    var email : String = ""
}