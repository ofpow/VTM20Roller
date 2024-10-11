package com.example.vtm20

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val regular: NumberPicker = findViewById(R.id.regular)
        val hunger: NumberPicker = findViewById(R.id.hunger)
        val difficulty: NumberPicker = findViewById(R.id.difficulty)
        val roll: Button = findViewById(R.id.roll)
        val regular_result: TextView = findViewById(R.id.regular_result)
        val hunger_result: TextView = findViewById(R.id.hunger_result)

        regular.maxValue = 10
        regular.minValue = 0
        regular.value = 5

        hunger.maxValue = 5
        hunger.minValue = 0
        hunger.value = 0

        difficulty.maxValue = 10
        difficulty.minValue = 1
        difficulty.value = 6

        roll.setOnClickListener {
            regular_result.setText(roll_regular(regular.value, difficulty.value))
            hunger_result.setText((roll_hunger(hunger.value, difficulty.value)))
        }
    }

    fun roll_regular(num_regular: Int, difficulty: Int): String {
        var result_text = ""
        var sucesses = 0

        for (i in 1..num_regular) {
            var roll = (1..10).random()
            result_text += (roll.toString() + "\n\n")
            if (roll == 10) {
                sucesses += 2
            } else if (roll == 1) {
                sucesses--
            } else if (roll >= difficulty) {
                sucesses++
            }
        }

        result_text += ("Successes: " + sucesses.toString())
        return result_text
    }

    fun roll_hunger(num_hunger: Int, difficulty: Int): String {
        var result_text = ""
        var sucesses = 0

        for (i in 1..num_hunger) {
            var roll = (1..10).random()
            result_text += (roll.toString() + "\n\n")
            if (roll == 10) {
                sucesses += 2
            } else if (roll == 1) {
                sucesses--
            } else if (roll >= difficulty) {
                sucesses++
            }
        }

        result_text += ("Successes: " + sucesses.toString())
        return result_text
    }
}