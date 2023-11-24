package com.example.mybmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.coroutines.jvm.internal.CompletedContinuation.context

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val heightEditText = findViewById<EditText>(R.id.et_height)
        val weightEditText = findViewById<EditText>(R.id.et_weight)
        val submitButton = findViewById<Button>(R.id.btn_check)


        submitButton.setOnClickListener {

            if(heightEditText.text.isEmpty()) {
                Toast.makeText(context: this,  text: "신장을 입력해주세요.", Toast.LENGTH.SHORT).show()
                return@setOnClickListener
            }

            if(weightEditText.text.isEmpty()) {
                Toast.makeText(context: this,  text: "체중을 입력해주세요.", Toast.LENGTH.SHORT).show()
                return@setOnClickListener
            }


            val height : Int heightEditText.text.toString().toInt()
            val weight : Int weightEditText.text.toString().toInt()

            val intent = intent(packageContext: this, ResultActivity::class.java)
            intent.putExtra(name: "height", height)
            intent.putExtra(name: "weight", weight)
            startActivity(intent)

        }

    }
}