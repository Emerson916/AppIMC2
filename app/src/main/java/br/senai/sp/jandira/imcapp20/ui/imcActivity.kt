package br.senai.sp.jandira.imcapp20.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import br.senai.sp.jandira.imcapp20.R
import kotlinx.android.synthetic.main.activity_imc.*

class imcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)


        val btnCalcular:Button = findViewById(R.id.button_calcular_imc)

        val edPeso: EditText = findViewById(R.id.ed_peso)
        val edAltura: EditText = findViewById(R.id.ed_altura)

        btnCalcular.setOnClickListener {

            if(ed_peso.text.isEmpty()){
                ed_peso.error = "Digite o Peso!"
            }

            if(ed_altura.text.isEmpty()){
                ed_altura.error = "Digite a altura!"
            }

            if(ed_peso.text.isNotEmpty() && ed_altura.text.isNotEmpty()) {
                val peso: Double = ed_peso.text.toString().toDouble()
                val altura: Double = ed_altura.text.toString().toDouble()

                val intent = Intent(this, ResultadoImcActivity::class.java)
                intent.putExtra("peso", peso)
                intent.putExtra("altura", altura)
                startActivity(intent)
            }
        }
    }
}