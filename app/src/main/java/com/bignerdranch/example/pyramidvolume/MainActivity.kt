package com.bignerdranch.example.pyramidvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var EditPanjang:EditText
    private lateinit var EditLebar:EditText
    private lateinit var EditTinggi:EditText
    private lateinit var ButtonCalculate:Button
    private lateinit var TextResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        EditPanjang = findViewById(R.id.edit_panjang)
        EditLebar = findViewById(R.id.edit_lebar)
        EditTinggi = findViewById(R.id.edit_tinggi)
        ButtonCalculate = findViewById(R.id.button_calculate)
        TextResult = findViewById(R.id.Text_result)

        ButtonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if(v != null){
            if(v.id == R.id.button_calculate){
                val MasukkanPanjang = EditPanjang.text.toString().trim()
                val MasukkanLebar = EditLebar.text.toString().trim()
                val MasukkanTinggi = EditTinggi.text.toString().trim()

                var KolomKosong = false
                if(MasukkanPanjang.isEmpty()){
                    KolomKosong = true
                    EditPanjang.error = "Kolom ini tidak boleh kosong"
                }
                if(MasukkanLebar.isEmpty()){
                    KolomKosong = true
                    EditLebar.error = "Kolom ini tidak boleh kosong"
                }
                if(MasukkanTinggi.isEmpty()){
                    KolomKosong = true
                    EditTinggi.error = "Kolom ini tidak boleh kosong"
                }
                if (!KolomKosong){
                        val LuasPermukaanBalok = (2* MasukkanPanjang.toDouble()* MasukkanLebar.toDouble()) *  (2* (MasukkanPanjang.toDouble()*MasukkanTinggi.toDouble()) * (2*MasukkanLebar.toDouble()* MasukkanTinggi.toDouble())
                    TextResult.text = LuasPermukaanBalok.toString()
                }

            }
        }

    }
}