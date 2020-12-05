package com.example.simondicefinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer

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

        val toastSaludo = Toast.makeText(applicationContext,"Comienza el juego!", Toast.LENGTH_SHORT)
        val toastFin = Toast.makeText(applicationContext,"Has perdido :(", Toast.LENGTH_SHORT)


        miModelo.listaReto.observe(this, Observer{
            miModelo.mostrarSecuencia(listaBotones)
        })

        start.setOnClickListener{
            miModelo.resetear()
            miModelo.añadirValor()
            toastSaludo.show()

        }

        check.setOnClickListener{
            if (!miModelo.compararSecuencia())
               toastFin.show()
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