package br.senai.sp.jandira.imcapp20.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.imcapp20.R
import kotlinx.android.synthetic.main.activity_novo_ususario.*

class NovoUsusarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_novo_ususario)

        button_salvar.setOnClickListener {
            //*** Criando o SharedPreferences

            val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
            val editor = dados.edit()
            editor.putString("nome", et_nome.text.toString())
            editor.putString("profissao", et_profissao.text.toString())
            editor.putInt("peso", et_peso.text.toString().toInt())
            editor.putInt("idade", et_data_nascimento.text.toString().toInt())
            editor.putString("email", et_email.text.toString())
            editor.putString("senha", et_senha.text.toString())
            editor.apply()

            Toast.makeText(this, "Dados gravavdosa com sucesso!!", Toast.LENGTH_SHORT)
            finish()
        }
    }
}