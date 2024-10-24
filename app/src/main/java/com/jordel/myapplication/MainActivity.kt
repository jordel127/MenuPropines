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
import androidx.databinding.DataBindingUtil
import com.jordel.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonCalcularPropina.setOnClickListener{
            val precio = binding.editTextText.text.toString().toDoubleOrNull() ?: 0.0
            var tempTip = binding.tipoDePropina.checkedRadioButtonId
            var typeTip = when (tempTip) {
                R.id.radioButton20 -> 20
                R.id.radioButton18 -> 18
                R.id.radioButton15 -> 15
                else -> 0
            }
            var propianfianl = precio  * typeTip/100

            val propinaRedondeada = if (binding.switchPropina.isChecked){
                kotlin.math.round(propianfianl)
            } else {
                propianfianl
            }

            binding.Propina.setText(propinaRedondeada.toString())

        }

    }
}