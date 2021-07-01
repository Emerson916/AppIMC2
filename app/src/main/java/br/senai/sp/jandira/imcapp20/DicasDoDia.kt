package br.senai.sp.jandira.imcapp20

import android.util.Log
import java.util.*

fun getDicaDoDia() : String {

    val dicas = listOf<String>(
        "Alimente-se melhor \n\n" +
                "Reduza alimentos com gordura, açúcar e sal. Tenha sempre frutas, verduras e legumes na alimentação diária.",

        "Movimente-se \n\n" +
                "Inicie uma atividade física. Evite escadas rolantes e elevadores e suba a pé.",

        "Beba água \n\n" +
                "Não espere ter sede para beber água. Quando você tem sede, significa que o corpo já está desidratado.",

        "Durma bem \n\n" +
                "Crie um ritual, deixe o ambiente escuro e silencioso. Quem dorme pouco e tem uma qualidade de sono ruim, tem mais chances de aumentar o peso."
    )

    val sorteio = Random()
    val dica = sorteio.nextInt(dicas.size)

    return dicas[dica]
}