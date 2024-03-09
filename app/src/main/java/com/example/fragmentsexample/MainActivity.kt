package com.example.fragmentsexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()


        val btn_one = findViewById<Button>(R.id.btn_first)
        val btn_two = findViewById<Button>(R.id.btn_second)
        val main_txt = findViewById<TextView>(R.id.main_txt)
        val et_txt = findViewById<EditText>(R.id.et_data)

        btn_one.setOnClickListener(){
            supportFragmentManager.beginTransaction().apply {

                replace(R.id.frame_layout,firstFragment)
                addToBackStack("") // add to layer by layer, so on back press it will back using layers
                commit()

            }
        }

        btn_two.setOnClickListener(){

            val bundle = Bundle()

            bundle.putString("StringData",et_txt.text.toString())
            secondFragment.arguments = bundle

            supportFragmentManager.beginTransaction().apply {

                replace(R.id.frame_layout,secondFragment)
                addToBackStack("")
                commit()

            }

        }


        val intent = intent
        val str_data = intent.getStringExtra("xyz")

        main_txt.text = str_data
    }


}