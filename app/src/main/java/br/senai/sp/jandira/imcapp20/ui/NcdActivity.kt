package br.senai.sp.jandira.imcapp20.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import br.senai.sp.jandira.imcapp20.R
import com.google.android.material.snackbar.Snackbar

class NcdActivity : AppCompatActivity() {

    lateinit var btnCalcular: Button
    lateinit var radioMasculino: RadioButton
    lateinit var radioFeminino: RadioButton
    lateinit var peso: EditText
    lateinit var idade: Spinner
    lateinit var nivelDeAtividade: Spinner
    lateinit var erro_idade: TextView
    lateinit var erro_Atividade_fisica: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ncd)

        btnCalcular = findViewById(R.id.button_calcular_ncd)
        radioMasculino = findViewById(R.id.masculino)
        radioFeminino = findViewById(R.id.feminino)

        peso = findViewById(R.id.ed_peso)
        idade = findViewById(R.id.idade)
        nivelDeAtividade = findViewById(R.id.atividade_fisica)
        erro_idade = findViewById(R.id.textViewIdade)
        erro_Atividade_fisica = findViewById(R.id.textViewAtividade)

        btnCalcular.setOnClickListener {
            if(peso.text.isEmpty()){
                peso.error = "Digite seu peso!"
            }
            else if(idade.selectedItemPosition == 0){
                erroIdade()
            }else if(nivelDeAtividade.selectedItemPosition == 0){
                erroNivelAtividade()
            }
            carregarDados()
        }
    }

    fun carregarDados(){

        val peso: Double = peso.text.toString().toDouble()
        val idade = idade.selectedItemPosition
        val nivelDeAtividade = nivelDeAtividade.selectedItemPosition

        val intent = Intent(this, ResultadoNcdActivity::class.java)
        intent.putExtra("peso", peso)
        intent.putExtra("idade", idade)
        intent.putExtra("nivelDeAtividade", nivelDeAtividade)

        if (radioFeminino.isChecked()){
            val genero = 'f'
            intent.putExtra("genero", genero)

            startActivity(intent)
        }else if (radioMasculino.isChecked()) {
            val genero = 'm'
            intent.putExtra("genero", genero)

            startActivity(intent)
        }
    }

    fun erroIdade(){
        if(idade.selectedItemPosition == 0) {
            Snackbar.make(
                findViewById<TextView>(R.id.textViewIdade),
                "Selecione sua idade",
                Snackbar.LENGTH_SHORT
            ).show()
            erro_idade.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_error_image,
                0
            )
        }
        else{
            erro_idade.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
        }

    }

    fun erroNivelAtividade(){
        if(nivelDeAtividade.selectedItemPosition == 0) {
            Snackbar.make(
                findViewById<TextView>(R.id.textViewAtividade),
                "Selecione um nivel de atividade",
                Snackbar.LENGTH_SHORT
            ).show()
            erro_Atividade_fisica.setCompoundDrawablesRelativeWithIntrinsicBounds(
                0,
                0,
                R.drawable.ic_error_image,
                0
            )
        }
       else{
            erro_Atividade_fisica.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,0,0)
        }
    }
}