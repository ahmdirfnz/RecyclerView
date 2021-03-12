package com.example.recyclerview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var adapter: NumberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = NumberAdapter(context = this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 3)

        val addButton = findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            showDialog()
        }

        val removeButton = findViewById<Button>(R.id.removeButton)
        removeButton.setOnClickListener {
            adapter.removeStudent()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.dialog_input)
        val editText = dialog.findViewById(R.id.input_id) as EditText
        val saveBtn = dialog.findViewById(R.id.saveButton) as Button
        val exitBtn = dialog.findViewById(R.id.exitbutton) as Button
        saveBtn.setOnClickListener {
            adapter.addStudent(editText.text.toString())
            dialog.dismiss()
        }
        exitBtn.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }
}