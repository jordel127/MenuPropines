package com.jordel.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SwitchCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val precioServicio: EditText = findViewById(R.id.editTextText)
        var propina: TextView = findViewById(R.id.Propina)
        val radioGroupTips: RadioGroup = findViewById(R.id.tipoDePropina)
        val propinaRedondeada: Switch = findViewById(R.id.switchPropina)
        val bottoCalcularPropina: Button = findViewById(R.id.buttonCalcularPropina)


        bottoCalcularPropina.setOnClickListener{
            val precio = precioServicio.text.toString().toDoubleOrNull() ?: 0.0
            var tempTip = radioGroupTips.checkedRadioButtonId
            var typeTip = when (tempTip) {
                R.id.radioButton20 -> 20
                R.id.radioButton18 -> 18
                R.id.radioButton15 -> 15
                else -> 0
            }
            var propianfianl = precio  * typeTip/100

            val propinaRedondeada = if (propinaRedondeada.isChecked){
                kotlin.math.round(propianfianl)
            } else {
                propianfianl
            }

            propina.setText(propinaRedondeada.toString())

        }

    }
}