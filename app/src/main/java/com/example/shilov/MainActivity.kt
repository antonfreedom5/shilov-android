package com.example.shilov

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newFragment = ItemsFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(
            R.id.mainActivity,
            newFragment
        )
        transaction.commit()
    }

}