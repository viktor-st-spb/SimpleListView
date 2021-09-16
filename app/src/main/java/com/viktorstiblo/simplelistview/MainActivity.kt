package com.viktorstiblo.simplelistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import com.viktorstiblo.simplelistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        //val myListView = findViewById<ListView>(R.id.lv_list_view)
        //val buttonNames = findViewById<Button>(R.id.btn_names)
        //val buttonFruits = findViewById<Button>(R.id.btn_fruits)
        //val buttonAnimals = findViewById<Button>(R.id.btn_animals)

        /******** Created the list of Names *******/
        val nameList = listOf("Vick","Alex","Valery","Dmitriy","Vladimir","Vitaliy",
            "Nick","Peter","Ed","Bob","Michail","Semen","Evgeniy","Stanislav","Nikolay")
        /******* Created an array list of strings *******/
        val fruitList = ArrayList<String>()
        /******* Added names to array list of strings *******/
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

        /***** Button on click listener implemented ******/
        binding.btnNames.setOnClickListener {
            // Created an adapter
            val myNamesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList)
            // Assigned an adapter to list view
            binding.lvListView.adapter = myNamesAdapter
            // On item click listener with toast message
            binding.lvListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${nameList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnFruits.setOnClickListener {
            val myFruitsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                fruitList)

            binding.lvListView.adapter = myFruitsAdapter

            binding.lvListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${fruitList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnAnimals.setOnClickListener {

            /****** Get animal list from res/values/animals.xml file ******/
            val animalList = resources.getStringArray(R.array.animals)

            val myAnimalAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
                animalList)

            binding.lvListView.adapter = myAnimalAdapter

            binding.lvListView.setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(this, "Pressed Item: ${animalList[position]} ($position)",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}