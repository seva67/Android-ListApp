package com.example.listapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
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
    private lateinit var bindingClass: ActivityMainBinding
    var test = InitOrderDemo("test")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickRB(view: View) {

        var tmp: RadioButton

        for (rb in bindingClass.group1.referencedIds) {
            tmp = findViewById<RadioButton>(rb)
            if (rb != view.id && tmp.isChecked())
                tmp.setChecked(false)
        }
    }
}
