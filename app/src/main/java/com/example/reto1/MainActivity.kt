package com.example.reto1

import android.os.Bundle
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        // --- FUNCIONALIDAD 1: CHECKBOX ---
        val cbAndroid = findViewById<CheckBox>(R.id.cbAndroid)
        val cbReact = findViewById<CheckBox>(R.id.cbReact)
        val cbFlutter = findViewById<CheckBox>(R.id.cbFlutter)
        val tvResultado = findViewById<TextView>(R.id.tvResultado)

        val actualizarTecnologias = {
            val seleccionadas = mutableListOf<String>()
            if (cbAndroid.isChecked) seleccionadas.add("Android")
            if (cbReact.isChecked) seleccionadas.add("React")
            if (cbFlutter.isChecked) seleccionadas.add("Flutter")

            tvResultado.text = if (seleccionadas.isEmpty()) {
                "Ninguna tecnología seleccionada"
            } else {
                "Tecnologías: ${seleccionadas.joinToString(", ")}"
            }
        }

        cbAndroid.setOnCheckedChangeListener { _, _ -> actualizarTecnologias() }
        cbReact.setOnCheckedChangeListener { _, _ -> actualizarTecnologias() }
        cbFlutter.setOnCheckedChangeListener { _, _ -> actualizarTecnologias() }

        // --- FUNCIONALIDAD 2: SEEKBAR ---
        val tvNivel = findViewById<TextView>(R.id.tvNivel)
        val seekBarNivel = findViewById<SeekBar>(R.id.seekBarNivel)

        seekBarNivel.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tvNivel.text = "Nivel seleccionado: $progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }
}