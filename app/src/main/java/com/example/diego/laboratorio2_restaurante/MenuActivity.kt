package com.example.diego.laboratorio2_restaurante
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.diego.laboratorio2_restaurante.Models.appExtensio
import kotlinx.android.synthetic.main.activity_menu.*


class MenuActivity: AppCompatActivity() {

    //Se crea el array de la comida disponible que se desplegará en el ListView
    var food = arrayOf("Queso y Pepperoni","Jamón","Margherita","Hawaiana","De Pollo","Napolitana","4 Quesos","Coca-Cola","Pepsi","RedBull","Seven")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //Se inicializa el Adapter con el contexto de app, el recurso para cada elemento de la lista, el array
        val adapter = ArrayAdapter(this,R.layout.listview_item, food)

        //Establecer el adapter creado en el ListView
        val listView:ListView = findViewById(R.id.menulist)
        listView.setAdapter(adapter)

        //Se implementa el Click listener a la listView para seleccionar un elemento de la lista
        listView.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val itemValue = listView.getItemAtPosition(position) as String

                //Mensaje que indica que se agregó
                Toast.makeText(applicationContext, food[position] + " se ha agregado a tu lista...",Toast.LENGTH_SHORT).show()
                appExtensio.add(food[position])
            }
        }

        //Si selecciona el botón Inicio
        home.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)//Se inicia la activity de Inicio

        }

    }
}