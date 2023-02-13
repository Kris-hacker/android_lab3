package com.example.lab3_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var candidateNames = resources.getStringArray(R.array.candidateNames)
        val listView : ListView = this.findViewById(R.id.myList)
//val arrayAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, candidateNames)

        var candidateList : MutableList<String> = candidateNames.toMutableList()
        val listAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, candidateList)
        listView.adapter = listAdapter
//using lambda syntax
        listView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "${candidateNames[position]}, seriously?", Toast.LENGTH_LONG).show()
            candidateList.add("Stephen Au")
            listAdapter.notifyDataSetInvalidated()
        }
    }
    fun onButtonClick(v : View){
        val i = Intent(this, PhotoListActivity::class.java)
        startActivity(i)
    }
}