package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numpress(view:View)
    {
        if(newOperation)
            findViewById<EditText>(R.id.screen).setText("")
      newOperation=false
        val buttonSelect = view as Button
       var data:String=findViewById<EditText>(R.id.screen).text.toString()
        when(buttonSelect.id)
        {
          R.id.bu0 ->data+="0"
            R.id.bu1 ->data+="1"
            R.id.bu2 ->data+="2"
            R.id.bu3 ->data+="3"
            R.id.bu4 ->data+="4"
            R.id.bu5 ->data+="5"
            R.id.bu6->data+="6"
            R.id.bu7 ->data+="7"
            R.id.bu8 ->data+="8"
            R.id.bu9 ->data+="9"
            R.id.budot->data+="."
            R.id.pm->data="-"+data
        }
       findViewById<EditText>(R.id.screen).setText(data)
    }

    var op=""
    var oldNumber=""
    var newOperation=true
    fun operation(view:View)
    {
        oldNumber=findViewById<EditText>(R.id.screen).text.toString()
        val buttonSelect = view as Button
        when(buttonSelect.id)
        {
            R.id.bumul ->{op="*"
                findViewById<EditText>(R.id.screen).setText(findViewById<EditText>(R.id.screen).text.toString()+"*") }
            R.id.buplus ->{op="+"
                findViewById<EditText>(R.id.screen).setText(findViewById<EditText>(R.id.screen).text.toString()+"+") }
            R.id.budiv ->{op="/"
                findViewById<EditText>(R.id.screen).setText(findViewById<EditText>(R.id.screen).text.toString()+"/") }
            R.id.busub ->{op="-"
                findViewById<EditText>(R.id.screen).setText(findViewById<EditText>(R.id.screen).text.toString()+"-") }

        }

        newOperation=true
    }

    fun finalOp(view: View)
    {
       var newNumber=findViewById<EditText>(R.id.screen).text.toString()
        var finalNumber:Double?=null
        when(op)
        {
            "*"->finalNumber=oldNumber.toDouble()*newNumber.toDouble()
            "+"->finalNumber=oldNumber.toDouble()+newNumber.toDouble()
            "-"->finalNumber=oldNumber.toDouble()-newNumber.toDouble()
            "/"->finalNumber=oldNumber.toDouble()/newNumber.toDouble()
        }
        findViewById<EditText>(R.id.screen).setText(finalNumber.toString())
        newOperation=true
    }
    fun cleanUp(view: View)
    {
        findViewById<EditText>(R.id.screen).setText("0")
        newOperation=true
    }
    fun percent(view:View)
    {
       val number:Double=findViewById<EditText>(R.id.screen).text.toString().toDouble()/100
        findViewById<EditText>(R.id.screen).setText(number.toString())
        newOperation=true
    }
}