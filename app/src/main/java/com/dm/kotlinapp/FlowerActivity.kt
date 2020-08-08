package com.dm.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.synthetic.main.activity_flower.*

class FlowerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flower)

        val flower = intent.getParcelableExtra<Flower>("flower")

        flower?.let {
            flowerTextView.text = "name: ${it.name}\ncolor: ${it.color}"
        }
    }
}

@Parcelize
data class Flower(val name: String, val color: Int, val imageRes: Int) : Parcelable