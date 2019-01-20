package com.example.diego.laboratorio2_restaurante.Models

import android.app.Application

class appExtensio: Application(){

    companion object:MenuOrder{

        override var menuOrder: ArrayList<String> = ArrayList()

        //Se eliminan elementos
        override fun clear() {
            menuOrder.clear()
        }

        //Se agrega elemento
        override fun add(element: String) {
            menuOrder.add(element)
        }

        //Se elemina un elemento
        override fun del(elementIndex: Int) {
            menuOrder.removeAt(elementIndex)
        }

        override fun done() {
        }

    }
}