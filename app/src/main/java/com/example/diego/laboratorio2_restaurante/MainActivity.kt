package com.example.diego.laboratorio2_restaurante

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*
//Actividad principal
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Al hacer click al boton, se abre la activity de Menu
        menu.setOnClickListener {
            val attempt = Intent(this, MenuActivity::class.java)
            startActivity(attempt)//Inicio de la actividad
        }

        //Al hacer click al boton, se abre la activiry de Orden
        orden.setOnClickListener {
            val attempt1 = Intent(this, OrdenActivity::class.java)
            startActivity(attempt1)//Inicio de la actividad
        }
    }
}
