package com.example.basiccalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var expressionCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val display: TextView = findViewById(R.id.display)

        val button0: Button = findViewById(R.id.button_0)
        val button1: Button = findViewById(R.id.button_1)
        val button2: Button = findViewById(R.id.button_2)
        val button3: Button = findViewById(R.id.button_3)
        val button4: Button = findViewById(R.id.button_4)
        val button5: Button = findViewById(R.id.button_5)
        val button6: Button = findViewById(R.id.button_6)
        val button7: Button = findViewById(R.id.button_7)
        val button8: Button = findViewById(R.id.button_8)
        val button9: Button = findViewById(R.id.button_9)

        val buttonAdd: Button = findViewById(R.id.button_add)
        val buttonSubtract: Button = findViewById(R.id.button_subtract)
        val buttonMultiply: Button = findViewById(R.id.button_multiply)
        val buttonDivide: Button = findViewById(R.id.button_divide)
        val buttonClear: Button = findViewById(R.id.button_clear)
        val buttonEquals: Button = findViewById(R.id.button_equals)

        val digitButtons = listOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)

        val operatorButtons = listOf(buttonAdd, buttonSubtract, buttonMultiply, buttonDivide)

        digitButtons.forEach { button ->
            button.setOnClickListener {
                if (display.text == "0") {
                    display.text = ""
                }
                display.append(button.text)
            }
        }

        operatorButtons.forEach { button ->
            button.setOnClickListener {
                if (expressionCount < 1 && display.text.isNotEmpty() && !display.text.last().isOperator()) {
                    display.append(button.text)
                    expressionCount++
                }
            }
        }

        buttonEquals.setOnClickListener {
            val expression = display.text.toString()
            val result = evaluateSimpleExpression(expression)
            if (result != null) {
                display.text = result.toString()
            } else {
                display.text = "Error"
            }
            expressionCount = 0
        }

        buttonClear.setOnClickListener {
            display.text = ""
            expressionCount = 0
        }
    }

    private fun evaluateSimpleExpression(expression: String): Double? {
        val regex = Regex("""(\d+\.?\d*)\s*([\+\-\*/])\s*(\d+\.?\d*)""")
        val matchResult = regex.matchEntire(expression)

        return if (matchResult != null) {
            val (leftOperand, operator, rightOperand) = matchResult.destructured
            val left = leftOperand.toDouble()
            val right = rightOperand.toDouble()

            when (operator) {
                "+" -> left + right
                "-" -> left - right
                "*" -> left * right
                "/" -> if (right != 0.0) left / right else null
                else -> null
            }
        } else {
            null
        }
    }

    private fun Char.isOperator(): Boolean {
        return this == '+' || this == '-' || this == '*' || this == '/'
    }
}
