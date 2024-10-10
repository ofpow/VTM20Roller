package com.example.vtm20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.NumberPicker

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val regular: NumberPicker = findViewById(R.id.regular)
        val hunger: NumberPicker = findViewById(R.id.hunger)
        val roll: Button = findViewById(R.id.roll)

        regular.maxValue = 10
        regular.minValue = 0
        regular.value = 5

        hunger.maxValue = 5
        hunger.minValue = 0
        hunger.value = 0

        roll.setOnClickListener {
            println(regular.value + hunger.value)
        }
    }
}