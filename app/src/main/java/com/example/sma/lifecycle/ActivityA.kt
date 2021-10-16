package com.example.sma.lifecycle

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.sma.R

class ActivityA : AppCompatActivity(), View.OnClickListener {
    private lateinit var startA : Button
    private lateinit var startB : Button
    private lateinit var startC : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)
        Log.d("Activity A", "onCreate")
        initButtons()
    }

    private fun initButtons(){
        startA = findViewById(R.id.lifecycle_aa)
        startA.setOnClickListener(this)
        startB = findViewById(R.id.lifecycle_ab)
        startB.setOnClickListener(this)
        startC = findViewById(R.id.lifecycle_ac)
        startC.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            startA.id -> Toast.makeText(this,"You already are in this activity",Toast.LENGTH_SHORT)
                .show()
            startB.id -> launchActivity(ActivityB::class.java)
            startC.id -> launchActivity(ActivityC::class.java)
        }
    }

    private fun launchActivity(activity : Class<*>?){
        val intent = Intent(this,activity)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d("Activity:A", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Activity:A", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Activity:A", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Activity:A", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("Activity:A", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Activity:A", "onDestroy")
    }
}