package com.example.gastoviagens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.gastoviagens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calcular) {
            calcular()
        }
    }

    private fun validar(): Boolean {
        return (
                binding.editDistancia.text.toString() != "" &&
                        binding.editPreco.text.toString() != "" &&
                        binding.editDistancia.text.toString() != "" &&
                        binding.editDistancia.text.toString().toFloat() > 0f
                )
    }


    private fun calcular() {
        if (validar()) {
            val distancia = binding.editDistancia.text.toString().toFloat()
            val preco = binding.editPreco.text.toString().toFloat()
            val autonomia = binding.editAutonomia.text.toString().toFloat()

            val valorViagem = ((distancia * preco) / autonomia)

            binding.textValorTotal.text = "R$ ${"%.2f".format(valorViagem)}"
        }else {
            Toast.makeText(this,R.string.mensagem_de_erro_validacao, Toast.LENGTH_LONG).show()
        }
    }

}