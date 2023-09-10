package com.example.resistorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private val colorValues = mapOf(
        "Negro" to 0,
        "Café" to 1,
        "Rojo" to 2,
        "Naranja" to 3,
        "Amarillo" to 4,
        "Verde" to 5,
        "Azul" to 6,
        "Violeta" to 7,
        "Gris" to 8,
        "Blanco" to 9
    )

    private val toleranceValues = mapOf(
        "Café" to "Tolerancia 1%",
        "Rojo" to "Tolerancia 2%",
        "Dorado" to "Tolerancia 5%",
        "Plateado" to "Tolerancia 10%"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val band1 = findViewById<Spinner>(R.id.selection_color_one_spinner)
        val band2 = findViewById<Spinner>(R.id.selection_color_two_spinner)
        val multiplier = findViewById<Spinner>(R.id.selection_multiplier_spinner)
        val tolerance = findViewById<Spinner>(R.id.selection_tolerance_spinner)
        val calculateButton = findViewById<Button>(R.id.calculate_button)
        val resultTextView = findViewById<TextView>(R.id.result_text_view)

        calculateButton.setOnClickListener {
            val band1Color = band1.selectedItem.toString()
            val band2Color = band2.selectedItem.toString()
            val multiplierColor = multiplier.selectedItem.toString()
            val toleranceColor = tolerance.selectedItem.toString()

            val band1Value = colorValues[band1Color] ?: 0
            val band2Value = colorValues[band2Color] ?: 0
            val multiplierValue = when (multiplierColor) {
                "Negro" -> 1
                "Café" -> 10
                "Rojo" -> 100
                "Naranja" -> 1000
                "Amarillo" -> 10000
                "Verde" -> 100000
                "Azul" -> 1000000
                "Violeta" -> 0.1
                "Gris" -> 0.01

                else -> 0
            }
            val toleranceValue = toleranceValues[toleranceColor] ?:0

            val resistanceValue = ((band1Value*10) + band2Value) * multiplierValue.toFloat()
            val info = "Valor de Resistencia: " + resistanceValue.toString() + "ohmios, con tolerancia de " + toleranceValue
            resultTextView.text = info
        }

    }
}