package com.example.primertarea

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlin.math.round
import com.example.primertarea.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }



    private fun initUI(){
        binding.button15.setOnClickListener {
            interfaceCalculateTip(.15)
            Toast.makeText(this,"Propina del 15%", Toast.LENGTH_LONG).show()
        }
        binding.button20.setOnClickListener {
            interfaceCalculateTip(.20)
            Toast.makeText(this,"Propina del 20%", Toast.LENGTH_LONG).show()
        }
        binding.button35.setOnClickListener {
            interfaceCalculateTip(.35)
            Toast.makeText(this,"Propina del 35%", Toast.LENGTH_LONG).show()
        }
        binding.redondeo.setOnClickListener {

            redondeo()
        }
    }

    private fun interfaceCalculateTip(percetange:Double){
        val amount = binding.editTextNumber.text.toString()
        val amountValue = amount.toDoubleOrNull()

        if (amountValue == null){
            binding.tipper.text="0.0"
            binding.total.text="0.0"
            return
        }
        if(amountValue == 0.0 || amountValue < 0){Toast.makeText(this,"Monto de cuenta inválido", Toast.LENGTH_LONG).show()}
        binding.tipper.text="${ amountValue * percetange}"
        binding.total.text="${amountValue * (1 + percetange)}"
    }
    private fun redondeo(){
        var redondeotip = binding.tipper.text.toString()
        var redbuenotip = redondeotip.toDoubleOrNull()
        var redondeototal = binding.total.text.toString()
        var redbuenototal = redondeototal.toDoubleOrNull()

        if (redbuenototal == null||redbuenotip == null){
            return
        }
        redbuenotip = round(redbuenotip)
        binding.tipper.text="${redbuenotip}"
        redbuenototal = round(redbuenototal)
        binding.total.text="${redbuenototal}"
    }
}




