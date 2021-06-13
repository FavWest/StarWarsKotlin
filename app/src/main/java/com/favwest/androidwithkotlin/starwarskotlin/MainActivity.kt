package com.favwest.androidwithkotlin.starwarskotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.edit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val updateButton = findViewById<Button>(R.id.update_button)
        val editName = findViewById<EditText>(R.id.edit_name)
        val displayName = findViewById<TextView>(R.id.display_name)
        val sharedPref = this.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE)
        sharedPref.edit() {
            putString(R.string.character_name.toString(), "OnCreate Name")
        }
        var name = sharedPref.getString(R.string.character_name.toString(), "Listener Name")
        displayName.text = name

        updateButton.setOnClickListener {
            sharedPref.edit() {
                putString(R.string.character_name.toString(), editName.text.toString())
                        .commit()
            }
            editName.setText("")
            name = sharedPref.getString(R.string.character_name.toString(), "Listener Name")
            displayName.text = name
        }
    }

}