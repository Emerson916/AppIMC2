package br.senai.sp.jandira.imcapp20.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.senai.sp.jandira.imcapp20.R
import br.senai.sp.jandira.imcapp20.calcularNcd
import br.senai.sp.jandira.imcapp20.getDicaDoDia
import kotlinx.android.synthetic.main.activity_resultado_ncd.*

class ResultadoNcdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_ncd)

        val txtNcd: TextView = findViewById(R.id.text_view_ncd)
        val textViewDica: TextView = findViewById(R.id.text_view_dica)

        val peso = intent.getDoubleExtra("peso",0.0)
        val idade = intent.getIntExtra("idade", 0)
        val nivelDeAtividade = intent.getIntExtra("nivelDeAtividade", 0)
        val genero = intent.getCharExtra("genero", 'm')

        val ncd = calcularNcd(
            idade,
            peso,
            nivelDeAtividade,
            genero
        )
        txtNcd.text = ncd.toInt().toString()
        text_view_dica.text = getDicaDoDia()
    }
}