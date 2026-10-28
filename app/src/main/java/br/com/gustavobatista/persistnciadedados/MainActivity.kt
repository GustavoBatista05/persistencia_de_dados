package br.com.gustavobatista.persistnciadedados

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.gustavobatista.persistnciadedados.db.DB
import br.com.gustavobatista.persistnciadedados.ui.theme.PersistênciaDeDadosTheme

class MainActivity : ComponentActivity() {
    private val pessoas = mutableStateOf<>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PersistênciaDeDadosTheme {
            }
        }
    }

    suspend fun listar() {
        val db = DB.DatabaseProvider.getDatabase(this)
        val dao = db.PessoaDAO()

        val resultado = dao.listarTodos()
    }

    @Composable
    private fun telaPrincipal() {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        val intent = Intent(
                            this@MainActivity,
                            Cadastro::class.java)
                        startActivity(intent)
                    }
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.icon_add),
                        contentDescription = "Botão adicionar registro"
                    ) {paddingValues ->
                        LazyColumn(
                            modifier = Modifier.fillMaxSize()
                        ) { }
                    }
                }
            }
        ) {}
    }
}