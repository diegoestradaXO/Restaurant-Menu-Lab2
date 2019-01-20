package com.example.diego.laboratorio2_restaurante
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.diego.laboratorio2_restaurante.*
import com.example.diego.laboratorio2_restaurante.Models.appExtensio
import kotlinx.android.synthetic.main.activity_orden.*

class OrdenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orden)

        //Se inicializa el Adapter con el contexto de app, el recurso para cada elemento de la lista, el array
        val adapter = ArrayAdapter(this,R.layout.listview_item, appExtensio.menuOrder)

        //Establecer el adapter creado en el ListView
        val listView: ListView = findViewById(R.id.pedido)
        listView.setAdapter(adapter)

        //Si selecciona el botón de Home
        home.setOnClickListener {
            val intento = Intent(this, MainActivity::class.java)
            startActivity(intento)//Se inicia la activity
        }

        //Si selecciona el botón de Borrar
        limpiar.setOnClickListener {
            appExtensio.clear()//Se borran los elementos
            adapter.notifyDataSetChanged()//Se refresca el Listview
        }

        //Si selecciona el botón de Hacer Pedido
        ordenar.setOnClickListener {
            appExtensio.clear()
            adapter.notifyDataSetChanged()//Se refresca el ListView
            //Mensaje indicando que la orden se hizo
            Toast.makeText(applicationContext,"Tu orden se envió exitosamente!", Toast.LENGTH_SHORT).show()
        }

        //Si el usuario hace un click largo o deja presionado
        listView.onItemLongClickListener = object : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
            //Mensaje que indicará el producto que se eliminó
            Toast.makeText(applicationContext,"Se eliminó " + appExtensio.menuOrder[position] + " del carrito de compra",Toast.LENGTH_SHORT).show()
            appExtensio.del(position)//Se borra de la lista de Pedido
            adapter.notifyDataSetChanged()//Se refresca el ListView al hacer cambio
            return true
        }
        }
    }
}