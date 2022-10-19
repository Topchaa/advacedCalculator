package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {



private lateinit var resultText:TextView
private var  firstNum:Double = 0.0
    private var  SecondNum:Double = 0.0
    private var Operator:String = ""
    private var isClicked:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   resultText = findViewById(R.id.results)




    }
    fun inputNumber(v:View) {
val button = v as Button
val buttontext = button.text.toString()

        if (resultText.text.toString() == "0" || isClicked){
            resultText.text = ""
            resultText.text = resultText.text.toString() + buttontext
            isClicked = false
        }else{
            resultText.text = resultText.text.toString() + buttontext


        }

    }
    fun operation(v:View){

        val btn = v as Button
        if (resultText.text.toString().isNotEmpty()) {
            var str = resultText.text.toString()
            firstNum = str.toDouble()
            Operator = btn.text.toString()
            resultText.text = ""
        }else{

           Operator  = btn.text.toString()
        }

    }

    fun equal(v:View) {

        val str2= resultText.text.toString()
        SecondNum = str2.toDouble()
        var res = 0.0
        if (Operator == "+") {  res = firstNum + SecondNum  }
        if (Operator == "-") {  res = firstNum - SecondNum  }
        if (Operator == "*") {  res = firstNum * SecondNum  }
        if (Operator == "/") {
            if (SecondNum.toInt() != 0 ){

                res = firstNum / SecondNum
            }else{
                Toast.makeText(this, "can't divide by zero" , Toast.LENGTH_SHORT).show()

            }
        }
        if(Operator == "%"){  res = (firstNum / SecondNum) * 100 }

        resultText.text = res.toString()
        isClicked = true

    }
    fun clear(v:View){
        resultText.text="0"
        firstNum == 0.0
        SecondNum == 0.0
        Operator == ""

    }
    fun inputDot(v:View){
        if(resultText.text.toString().contains("." , ignoreCase = true)){

            Toast.makeText(this , "No More Dots" , Toast.LENGTH_SHORT).show()
        }else{
            resultText.text = resultText.text.toString() + "."

        }





    }

    fun squareroot(v:View){
     val sqrtNum  = resultText.text.toString().toDouble()
        resultText.text = sqrt(sqrtNum).toString()
        isClicked = true

    }

    fun setsign(v: View){

        if (resultText.text.toString() != "0" && resultText.text.toString() != "0.0" ){

            resultText.text = "-"+ resultText.text.toString()
        }

    }


}