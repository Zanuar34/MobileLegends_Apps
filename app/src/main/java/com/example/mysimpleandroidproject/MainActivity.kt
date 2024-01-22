package com.example.mysimpleandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvHero: RecyclerView
    private val list = ArrayList<Hero>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHero = findViewById(R.id.rv_hero)
        rvHero.setHasFixedSize(true)

        list.addAll(getListHero())
        showRecyclerList()

        val btnMoveActivity: Button = findViewById(R.id.about_page)
        btnMoveActivity.setOnClickListener(this)
    }

    private fun getListHero(): ArrayList<Hero> {
        val dataHero = resources.getStringArray(R.array.data_hero)
        val dataRole = resources.getStringArray(R.array.data_role)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataStoryHero = resources.getStringArray(R.array.data_storyofhero)
        val listHero = ArrayList<Hero>()
        for (i in dataHero.indices) {
            val hero = Hero(dataHero[i], dataRole[i], dataPhoto.getResourceId(i,-1), dataStoryHero[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvHero.layoutManager = LinearLayoutManager(this)
        val listHeroAdapterAdapter = ListHeroAdapter(list)
        rvHero.adapter = listHeroAdapterAdapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
