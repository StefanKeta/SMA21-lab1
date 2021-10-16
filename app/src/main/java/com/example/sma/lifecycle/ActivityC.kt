package com.example.sma.lifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sma.R

class ActivityC : AppCompatActivity(), View.OnClickListener {
    private lateinit var startA : Button
    private lateinit var startB : Button
    private lateinit var startC : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)
        Log.d("Activity C", "onCreate")
        initButtons()
    }

    private fun initButtons(){
        startA = findViewById(R.id.lifecycle_ca)
        startA.setOnClickListener(this)
        startB = findViewById(R.id.lifecycle_cb)
        startB.setOnClickListener(this)
        startC = findViewById(R.id.lifecycle_cc)
        startC.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            startA.id -> launchActivity(ActivityA::class.java)
            startB.id -> launchActivity(ActivityB::class.java)
            startC.id -> Toast.makeText(this,"You already are in this activity", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun launchActivity(activity : Class<*>?){
        val intent = Intent(this,activity)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity:C", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity:C", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity:C", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity:C", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity:C", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity:C", "onDestroy")
    }
}