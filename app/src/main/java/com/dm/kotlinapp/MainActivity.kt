package com.dm.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sendBtn.setOnClickListener {
            val flower = Flower(nameEditText.text.toString(), Color.RED, R.drawable.flower)
            startActivity(Intent(this@MainActivity, FlowerActivity::class.java).apply {
                putExtra("flower", flower)
            })
        }

        val flowerList = mutableListOf(
            Flower("Rose", Color.RED, R.drawable.flower),
            Flower("Iris", Color.BLUE, R.drawable.flower),
            Flower("Tulip", Color.GREEN, R.drawable.flower),
            Flower("Orchid", Color.RED, R.drawable.flower),
            Flower("Sunflower", Color.BLUE, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Daisy", Color.RED, R.drawable.flower),
            Flower("Lilly", Color.BLUE, R.drawable.flower)
        )

        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = FlowerAdapter(flowerList).apply {
            setOnItemClickListener {
                Toast.makeText(this@MainActivity, "clicked on $it", Toast.LENGTH_SHORT).show()
            }
        }
    }
}