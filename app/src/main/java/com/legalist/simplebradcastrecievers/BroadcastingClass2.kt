package com.legalist.simplebradcastrecievers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastingClass2 : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        Toast.makeText(context, "Inner2 class broadcast", Toast.LENGTH_LONG).show()
    }
}