package com.example.sma.lifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sma.R

class ActivityB : AppCompatActivity(),View.OnClickListener {
    private lateinit var startA : Button
    private lateinit var startB : Button
    private lateinit var startC : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)
        Log.d("Activity B", "onCreate")
        initButtons()
    }

    private fun initButtons(){
        startA = findViewById(R.id.lifecycle_ba)
        startA.setOnClickListener(this)
        startB = findViewById(R.id.lifecycle_bb)
        startB.setOnClickListener(this)
        startC = findViewById(R.id.lifecycle_bc)
        startC.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            startA.id -> launchActivity(ActivityA::class.java)
            startB.id -> Toast.makeText(this,"You already are in this activity", Toast.LENGTH_SHORT)
                .show()
            startC.id -> launchActivity(ActivityC::class.java)
        }
    }

    private fun launchActivity(activity : Class<*>?){
        val intent = Intent(this,activity)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity:B", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity:B", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity:B", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity:B", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity:B", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity:B", "onDestroy")
    }
}