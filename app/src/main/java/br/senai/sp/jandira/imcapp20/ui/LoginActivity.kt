package br.senai.sp.jandira.imcapp20.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import br.senai.sp.jandira.imcapp20.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var editUser: EditText
    lateinit var editPassword: EditText
    lateinit var btnLogin: Button
    lateinit var mensagemErro: TextView
    lateinit var tvCrieSuaConta: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE)
        val lembrar = dados.getBoolean("lembrar", false)

        if (lembrar == true){
            abrirDashBoard()
        }

        editUser = findViewById(R.id.email)
        editPassword = findViewById(R.id.password)
        btnLogin = findViewById(R.id.button_login)
        mensagemErro = findViewById(R.id.erro_login)
        tvCrieSuaConta = findViewById(R.id.crieSuaConta)

        tvCrieSuaConta.setOnClickListener{
            val intent = Intent(this, NovoUsusarioActivity::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener {
            login()
        }
    }

    private fun abrirDashBoard() {
        val intent = Intent(this, DashBoardActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun login() {
        //*** Dados manuais ***/

        //email : user@email.com
        //senha : 123
        val user = editUser.text.toString()
        val pass = editPassword.text.toString()


        //*** Dados do SharedPreferences ***/

        //email : junin@email.com
        //senha :  123

        val dados = getSharedPreferences("dados_usuario", Context.MODE_PRIVATE )
        val userPreferences = dados.getString("email", "Não encontrado")
        val passPreferences = dados.getString("senha", "Não encontrado")

        // Validação do email e senha //

        if(user == userPreferences && pass == passPreferences){

            // Gravar o lembrar no sharedPreferences
            val editor = dados.edit()
            editor.putBoolean("lembrar", checkbox_lembrar.isChecked)
            editor.apply()

            abrirDashBoard()
        }else{
            mensagemErro.text = "Usuario ou senha incorreta!"
        }
    }
}