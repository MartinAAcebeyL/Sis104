package sis104.tareas.sis104kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main_data_base.*
import kotlinx.android.synthetic.main.activity_main_operacion.*

class MainActivityOperacion : AppCompatActivity() {
    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_operacion)

        txtResultado.text = "0"
        operacion = SIN_OPERACION

        btn0.setOnClickListener { numberPressed("0") }
        btn1.setOnClickListener { numberPressed("1") }
        btn2.setOnClickListener { numberPressed("2") }
        btn3.setOnClickListener { numberPressed("3") }
        btn4.setOnClickListener { numberPressed("4") }
        btn5.setOnClickListener { numberPressed("5") }
        btn6.setOnClickListener { numberPressed("6") }
        btn7.setOnClickListener { numberPressed("7") }
        btn8.setOnClickListener { numberPressed("8") }
        btn9.setOnClickListener { numberPressed("9") }
        btnPunto.setOnClickListener { }


        btnMas.setOnClickListener { operationPressed(SUMA) }
        btnResta.setOnClickListener { operationPressed(RESTA) }
        btnProduct.setOnClickListener { operationPressed(MULTIPLICACION) }
        btnDivision.setOnClickListener { operationPressed(DIVISION) }

        btnIgual.setOnClickListener { resolvePressed() }
        bntBorrar.setOnClickListener { txtResultado.text = "0"
            num1 = 0.0
            num2 = 0.0 }
    }
    private fun numberPressed(num: String){
        if(txtResultado.text == "0" && num != ".") {
            txtResultado.text = "$num"
        } else {
            txtResultado.text = "${txtResultado.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = txtResultado.text.toString().toDouble()
        } else {
            num2 = txtResultado.text.toString().toDouble()
        }
    }

    private fun operationPressed(operacion: Int){
        this.operacion = operacion
        num1 = txtResultado.text.toString().toDouble()

        txtResultado.text = "0"
    }

    private fun resolvePressed(){

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        txtResultado.text =  "%.2f".format(result)
    }


    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }

}