package com.example.mysimpleandroidproject

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailHero : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON: String = "Hero"
    }

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_hero_layout)

        val receivedData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Hero>(DetailHero.EXTRA_PERSON, Hero::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Hero>(DetailHero.EXTRA_PERSON)
        }

        val heroTextView = findViewById<TextView>(R.id.hero_name)
        val imageView = findViewById<ImageView>(R.id.imageView5)
        val roleTextView = findViewById<TextView>(R.id.role_hero)
        val storyTextView = findViewById<TextView>(R.id.tv_story)

        if (receivedData != null){
            heroTextView.text = receivedData.heroName
            roleTextView.text = receivedData.role
            storyTextView.text = receivedData.storyHero

            Glide.with(this)
                .load(receivedData.photo)
                .into(imageView)

        }
    }
}