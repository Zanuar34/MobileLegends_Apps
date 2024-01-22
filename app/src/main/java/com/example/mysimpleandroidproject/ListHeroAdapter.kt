package com.example.mysimpleandroidproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListHeroAdapter (private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {



    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvHero: TextView = itemView.findViewById(R.id.tv_hero_name)
        val tvRole: TextView = itemView.findViewById(R.id.tv_role)
        val buttonDetailHero : Button = itemView.findViewById(R.id.button_detail)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_hero_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listHero.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (hero, role, photo) = listHero[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)

        holder.tvHero.text = hero
        holder.tvRole.text = role


        holder.buttonDetailHero.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailHero::class.java)
            intentDetail.putExtra(DetailHero.EXTRA_PERSON, listHero[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }


    }
}