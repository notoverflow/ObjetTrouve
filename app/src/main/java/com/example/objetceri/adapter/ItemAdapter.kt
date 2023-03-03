package com.example.objetceri.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.objetceri.FindFragment
import com.example.objetceri.ItemModel
import com.example.objetceri.MainActivity
import com.example.objetceri.R

class ItemAdapter (
    private val context: FindFragment,
    private val itemList: List<ItemModel>

): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val imageItem= view.findViewById<ImageView>(R.id.imageItem)
        val titreItem=view.findViewById<TextView>(R.id.titreItem)
        val descriptionItem=view.findViewById<TextView>(R.id.descriptionItem)
        val dateItem=view.findViewById<TextView>(R.id.dateItem)
        val buildingItem=view.findViewById<TextView>(R.id.buildingItem)
        val roomItem=view.findViewById<TextView>(R.id.roomItem)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lost, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]

        Glide.with(context).load(item.imageItemUrl).into(holder.imageItem)

        holder.titreItem.text = item.titreItem
        holder.descriptionItem.text = item.descriptionItem
        holder.dateItem.text = item.dateItem
        holder.buildingItem.text = item.buildingItem
        holder.roomItem.text = item.roomItem
    }
    override fun getItemCount(): Int = itemList.size


}