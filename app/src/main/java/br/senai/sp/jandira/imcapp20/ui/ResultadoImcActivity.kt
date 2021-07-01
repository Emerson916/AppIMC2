package br.senai.sp.jandira.imcapp20.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.senai.sp.jandira.imcapp20.R
import br.senai.sp.jandira.imcapp20.calcularImc
import br.senai.sp.jandira.imcapp20.getDicaDoDia
import br.senai.sp.jandira.imcapp20.obterStatus

class ResultadoImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imc)

        val txtImc: TextView = findViewById(R.id.text_view_imc)
        val txtStatus: TextView = findViewById(R.id.text_view_status)
        val txtStatusRisk: TextView = findViewById(R.id.text_view_frase_status)
        val txtDica: TextView = findViewById(R.id.text_view_dica)

        val peso = intent.getDoubleExtra("peso",0.0)
        val altura = intent.getDoubleExtra("altura", 0.0)

        val imc = calcularImc(peso, altura)
        txtImc.text = String.format("%.1f", imc )

        val resultados = obterStatus(imc)

        //Armazenar os dados no preferences
        //val editPreferences = SharedPreferences.Editor()

        txtStatus.text = resultados[0]
        txtStatusRisk.text = resultados[1]

        txtDica.text = getDicaDoDia()
    }
}