package com.viktorstiblo.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myListView = findViewById<ListView>(R.id.lv_list_view)
        val buttonNames = findViewById<Button>(R.id.btn_names)
        val buttonFruits = findViewById<Button>(R.id.btn_fruits)
        val buttonAnimals = findViewById<Button>(R.id.btn_animals)


        val nameList = listOf("Vick","Alex","Valery","Dmitriy","Vladimir","Vitaliy",
            "Nick","Peter","Ed","Bob","Michail","Semen","Evgeniy","Stanislav","Nikolay")

        val fruitList = ArrayList<String>()
        fruitList.add("Apple")
        fruitList.add("Lime")
        fruitList.add("Melon")
        fruitList.add("Watermelon")
        fruitList.add("Orange")
        fruitList.add("Banana")
        fruitList.add("Nectarine")
        fruitList.add("Grape")
        fruitList.add("Lemon")
        fruitList.add("Pear")
        fruitList.add("Mango")
        fruitList.add("Mandarin")
        fruitList.add("Apricot")
        fruitList.add("Kiwi")
        fruitList.add("PineApple")

        buttonNames.setOnClickListener {
            val myNamesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)

            myListView.adapter = myNamesAdapter

            myListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${nameList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }

        buttonFruits.setOnClickListener {
            val myFruitsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                fruitList)

            myListView.adapter = myFruitsAdapter

            myListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${fruitList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }

        buttonAnimals.setOnClickListener {

            val animalList = resources.getStringArray(R.array.animals)

            val myAnimalAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                animalList)

            myListView.adapter = myAnimalAdapter

            myListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${animalList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}