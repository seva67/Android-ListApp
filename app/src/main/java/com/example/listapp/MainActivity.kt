package com.example.listapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.listapp.databinding.ActivityMainBinding


class Person(val name: String) {
    val children: MutableList<Person> = mutableListOf()
    init {
        Log.d("MyLog", "${this.name.toString()}")
    }

    constructor(name: String, parent: Person) : this(name) {
        Log.d("MyLog","Дополнительный конструктор ${this.name} от ${parent.name.toString()}")
        parent.children.add(this)
    }
}

class Constructors {
    init {
        Log.d("MyLog", "Блок инициализации")
    }
    constructor(i: Int) {
        Log.d("MyLog", "Constructor $i")
    }
}

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding

    var test1 = Constructors(3)
    var test3 = Person("Something")
    var test4 = Person("Somthing else", test3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClick_sdButton(view: View) {
        var intent: Intent = Intent("android.intent.action.ACTION_SHUTDOWN")
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false)
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
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
