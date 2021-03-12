package com.example.recyclerview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import java.time.Duration

class NumberAdapter(val context: Context): RecyclerView.Adapter<NumberAdapter.ViewHolder>() {

    var students = ArrayList<String>()

    init {
        students.add("Salam")
    }

    fun addStudent(name: String) {
        students.add(name)
        notifyDataSetChanged()
    }

    fun  removeStudent() {
        students.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.textView)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_text, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var student = students[position]
        holder.textView.text = "position $position $student"
        holder.textView.setOnClickListener {
            Toast.makeText(context, "Position: $position $student", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return students.size
    }

}