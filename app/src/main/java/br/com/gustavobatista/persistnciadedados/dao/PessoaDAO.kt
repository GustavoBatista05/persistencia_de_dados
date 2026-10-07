package br.com.gustavobatista.persistnciadedados.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.gustavobatista.persistnciadedados.domain.Pessoa

@Dao
interface PessoaDAO {

    @Insert
    suspend fun inserir (pessoa: Pessoa)

    @Update
    suspend fun atualizar (pessoa: Pessoa)

    @Delete
    suspend fun deletar (pessoa: Pessoa)

    @Query("SELECT * FROM pessoa")
    suspend fun listarTodos (): List<Pessoa>

    @Query("SELECT * FROM pessoa WHERE id = :id")
    suspend fun buscarPorId (id: Long): Pessoa?
}