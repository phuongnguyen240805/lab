package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //input
        val firstInput : EditText = findViewById(R.id.firstInput)
        val secondInput: EditText = findViewById(R.id.secondInput)

        //btn
        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSubtract : Button = findViewById(R.id.btnSubtract)
        val btnMultiply: Button = findViewById(R.id.btnMultiply)
        val btnDivide: Button = findViewById(R.id.btnDivide)

        // Text view
        val viewResult : TextView = findViewById(R.id.viewResult)
        val viewRange : TextView = findViewById(R.id.viewRange)

        // handle click btn add
        btnAdd.setOnClickListener({
            val first_num_str = firstInput.text.toString() // convert string
            val second_num_str = secondInput.text.toString()

            val first_num : Int = first_num_str.toIntOrNull() ?: 0 //  ép kiểu dữ liệu từ str sang Int
            val second_num : Int = second_num_str.toIntOrNull() ?: 0
            val calculator = HandleCalculator(first_num, second_num)

            val result = calculator.add()
            val range = calculator.checkRange(result)

            viewResult.text = "Result: $result"
            viewRange.text = "Range: $range"
        })

        // handle click btn subtract
        btnSubtract.setOnClickListener({
            val first_num_str = firstInput.text.toString() // convert string
            val second_num_str = secondInput.text.toString()

            val first_num : Int = first_num_str.toIntOrNull() ?: 0 //  ép kiểu dữ liệu từ str sang Int
            val second_num : Int = second_num_str.toIntOrNull() ?: 0
            val calculator = HandleCalculator(first_num, second_num)

            val result = calculator.sub()
            val range = calculator.checkRange(result)

            viewResult.text = "Result: $result"
            viewRange.text = "Range: $range"
        })

        // handle click btn multiply
        btnMultiply.setOnClickListener({
            val first_num_str = firstInput.text.toString() // convert string
            val second_num_str = secondInput.text.toString()

            val first_num : Int = first_num_str.toIntOrNull() ?: 0 //  ép kiểu dữ liệu từ str sang Int
            val second_num : Int = second_num_str.toIntOrNull() ?: 0
            val calculator = HandleCalculator(first_num, second_num)

            val result = calculator.mul()
            val range = calculator.checkRange(result)

            viewResult.text = "Result: $result"
            viewRange.text = "Range: $range"
        })

        // handle click btn divide
        btnDivide.setOnClickListener({
            val first_num_str = firstInput.text.toString() // convert string
            val second_num_str = secondInput.text.toString()

            val first_num : Int = first_num_str.toIntOrNull() ?: 0 //  ép kiểu dữ liệu từ str sang Int
            val second_num : Int = second_num_str.toIntOrNull() ?: 0
            val calculator = HandleCalculator(first_num, second_num)

            val result = calculator.div()
            val range = calculator.checkRange(result)

            viewResult.text = "Result: $result"
            viewRange.text = "Range: $range"
        })
    }
}