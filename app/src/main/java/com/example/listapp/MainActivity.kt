package com.example.listapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.listapp.databinding.ActivityMainBinding

class InitOrderDemo(name: String) {
    val firstProperty = "Первое свойство: $name".also(::println)

    val secondProperty = "Второе свойство: ${name.length}".also(::println)

    init {
        println("Первый блок инициализации: ${name}")
    }

    init {
        println("Второй блок инициализации: ${name.length}")
    }
}
class MainActivity : AppCompatActivity() {

    //private lateinit var bindingClass: ActivityMainBinding
    var test = InitOrderDemo("test")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //bindingClass = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(bindingClass.root)
    }
}
