package com.example.shilov

import android.app.FragmentTransaction
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.shilov.model.CustomOrder
import com.example.shilov.source.CustomOrderSource
import kotlinx.coroutines.runBlocking


class AddOrderFragment : android.app.Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = runBlocking {
        val view = inflater.inflate(R.layout.add_item, container, false)
        val firstName = view.findViewById<EditText>(R.id.firstNameText)
        val lastName = view.findViewById<EditText>(R.id.lastNameText)
        val phone = view.findViewById<EditText>(R.id.phoneText)
        val note = view.findViewById<EditText>(R.id.noteText)

        val button = view.findViewById<Button>(R.id.addButton)
        button.setOnClickListener { onClick(firstName.text.toString(), lastName.text.toString(), phone.text.toString(), note.text.toString()) }
        return@runBlocking view
    }

    private fun onClick(firstName: String, lastName: String, phone: String, note: String) = runBlocking {
        CustomOrderSource().add(CustomOrder(id = 0, firstName, lastName, phone, note))

        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }
}