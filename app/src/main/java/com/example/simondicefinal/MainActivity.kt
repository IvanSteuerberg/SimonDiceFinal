package com.example.simondicefinal


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val miModelo by viewModels<MyViewModel>()

        val start = findViewById<Button>(R.id.start_button)
        val check = findViewById<Button>(R.id.check_button)

        val blue = findViewById<Button>(R.id.blue_button)
        val red = findViewById<Button>(R.id.red_button)
        val yellow = findViewById<Button>(R.id.yellow_button)
        val green = findViewById<Button>(R.id.green_button)

        val listaBotones = listOf(green,red,blue,yellow)

        val toastStart = Toast.makeText(applicationContext,R.string.start, Toast.LENGTH_SHORT)
        val toastFinish = Toast.makeText(applicationContext,R.string.finish, Toast.LENGTH_SHORT)
        val score = findViewById<TextView>(R.id.infoText)
        val text = getString(R.string.Text)


        miModelo.listaReto.observe(this, {
            miModelo.mostrarSecuencia(listaBotones)
            score.text = "$text ${miModelo.listaReto.value!!.size}"
        })

        start.setOnClickListener{
            miModelo.resetear()
            miModelo.sumarValor()
            toastStart.show()

        }

        check.setOnClickListener{
            if (!miModelo.compararSecuencia())
               toastFinish.show()
            score.text = "$text 0"
        }

        green.setOnClickListener{
            miModelo.guardarSecuencia(miModelo.listaJugador,1)
        }

        red.setOnClickListener{
            miModelo.guardarSecuencia(miModelo.listaJugador,2)
        }

        blue.setOnClickListener{
            miModelo.guardarSecuencia(miModelo.listaJugador,3)
        }

        yellow.setOnClickListener{
            miModelo.guardarSecuencia(miModelo.listaJugador,4)
        }












    }
}