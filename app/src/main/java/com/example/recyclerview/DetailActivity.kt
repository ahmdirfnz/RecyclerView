package com.example.recyclerview

import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

const val STUDENT_ID_EXTRA = "student_id"

class DetailActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        val detailTextView = findViewById<TextView>(R.id.detailTextView)
        val id = intent.getStringExtra(STUDENT_ID_EXTRA)
        id?.let {
            detailTextView.text = it
        }

        val imageView = findViewById<ImageView>(R.id.imageView)
        val imageUrl = "https://upload.wikimedia.org/wikipedia/commons/3/32/-_Flower_02_-.jpg"
        Glide
            .with(this)
            .load(imageUrl)
            .fitCenter()
            .into(imageView)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}