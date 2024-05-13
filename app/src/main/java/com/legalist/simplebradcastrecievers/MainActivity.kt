package com.legalist.simplebradcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.legalist.simplebradcastrecievers.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        innerclass()
        broadcast()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun innerclass() {
        binding.button.setOnClickListener {
            val intent = Intent(this, BroadcastingClass::class.java)
            sendBroadcast(intent)
        }
    }

    fun broadcast() {
        binding.button2.setOnClickListener {
            val intent = Intent(this, BroadcastingClass2::class.java)
            sendBroadcast(intent)
        }
    }

    class BroadcastingClass : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Inner class broadcast", Toast.LENGTH_LONG).show()
        }


    }
}
