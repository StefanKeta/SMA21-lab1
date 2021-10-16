package com.example.sma.intents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.sma.R

class IntentFilterActivity : AppCompatActivity() {
    private lateinit var tv : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_filter)
        tv = findViewById(R.id.intent_tv)
        tv.text = intent.getStringExtra("name")
    }
}