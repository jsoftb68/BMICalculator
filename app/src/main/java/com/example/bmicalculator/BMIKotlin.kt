package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivityKt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myButtonListenerMethod()
    }

    private fun myButtonListenerMethod() {
        val weightInput = findViewById<View>(R.id.weightInput) as EditText
        val heightInput = findViewById<View>(R.id.heightInput) as EditText
        val button = findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            val weight: Float = weightInput.text.toString().toFloat()
            val height: Float = heightInput.text.toString().toFloat()
            val bmi = weight / (height * height)
            (findViewById<View>(R.id.BMIResult) as EditText).setText(String.format("%.1f", bmi))
            (findViewById<View>(R.id.BMICategory) as TextView).text = CategoryText(bmi)
        }
    }

    private fun CategoryText(bmi: Float): String {
        var s: String? = null
        s = if (bmi >= 40) "Very serverely obese" else if (bmi >= 35) "Serverely obese" else if (bmi >= 30) "Moderately obese" else if (bmi >= 25) "Overweight" else if (bmi >= 18.5) "Normal" else if (bmi >= 16) "Underweight" else if (bmi >= 15) "Severely underweight" else "Very severely underweight"
        return s
    }
}