package com.example.sma.intents

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.sma.R
import java.util.jar.Manifest

class MainIntentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var googleView: Button
    private lateinit var telView: Button
    private lateinit var googleSMA: Button
    private lateinit var telSMA: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_intent)
        initButtons()
    }

    private fun initButtons() {
        googleView = findViewById(R.id.intent_main_view_google)
        telView = findViewById(R.id.intent_main_view_tel)
        googleSMA = findViewById(R.id.intent_main_SMA_google)
        telSMA = findViewById(R.id.intent_main_SMA_tel)
        googleView.setOnClickListener(this)
        telView.setOnClickListener(this)
        googleSMA.setOnClickListener(this)
        telSMA.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            googleView.id -> launchViewGoogle()
            telView.id -> launchViewTel()
            googleSMA.id -> launchSMAGoogle()
            telSMA.id -> launchSMATel()
        }
    }

    private fun launchViewGoogle(){
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("https://www.google.com")
        intent.putExtra("name", "GOOGLE")
        startActivity(intent)
    }
    private fun launchViewTel(){
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = Uri.parse("tel:00401213456")
        intent.putExtra("name","TELEPHONE")
        startActivity(intent)
    }
    private fun launchSMAGoogle(){
        val intent = Intent()
        intent.action = "sma.LAUNCH"
        intent.data = Uri.parse("https://www.google.com/")
        intent.putExtra("name", "GOOGLE")
        startActivity(intent)
    }
    private fun launchSMATel(){
        val intent = Intent()
        intent.action = "sma.LAUNCH"
        intent.data = Uri.parse("tel:00401213456")
        intent.putExtra("name","TELEPHONE")
        startActivity(intent)
    }
}