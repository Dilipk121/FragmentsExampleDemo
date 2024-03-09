package com.example.fragmentsexample

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class FirstFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val view = inflater.inflate(R.layout.fragment_first, container, false)


        val text_one = view.findViewById<TextView>(R.id.txt_fr_one)
        val btn_one = view.findViewById<Button>(R.id.btn_fr_one)

        val et_txt = view.findViewById<EditText>(R.id.et_fr_one)
        val btn_two = view.findViewById<Button>(R.id.btn_fr_two)




        btn_one.setOnClickListener(){

            text_one.text = "SET TEXT IN FRAGMENT"

        }

        //passing data from Fragment to Activity using Interface
        btn_two.setOnClickListener(){

            val msg = et_txt.text.toString()

            val intent = Intent(requireContext(),MainActivity::class.java) // refer to main activity
            intent.putExtra("xyz",msg)

            startActivity(intent)


        }

        return view
    }


}