package com.example.shilov

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shilov.adapter.OrderAdapter
import com.example.shilov.source.CustomOrderSource
import kotlinx.coroutines.runBlocking

class ItemsFragment : android.app.Fragment() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = runBlocking {
        val view = inflater.inflate(R.layout.items, container, false)
        val result = CustomOrderSource().getAll()
        val names = result.map { it.toString() }
        val ids = result.map { it.id }

        val recyclerView = view!!.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = OrderAdapter(ids, names) { updateFragment() }

        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener { addClickEvent() }
        return@runBlocking view
    }

    private fun updateFragment(): Unit = runBlocking {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addClickEvent() {
        val newFragment = AddOrderFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(
            R.id.itemsFragment,
            newFragment
        )
        transaction.commit()
    }
}