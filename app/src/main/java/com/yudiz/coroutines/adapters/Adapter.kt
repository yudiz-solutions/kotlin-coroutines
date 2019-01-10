package com.yudiz.coroutines.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yudiz.coroutines.R
import com.yudiz.coroutines.model.Model
import kotlinx.android.synthetic.main.row.view.*


class Adapter(val context: Context, val list: List<Model>) : RecyclerView.Adapter<Adapter.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val pos = holder.adapterPosition
        holder.itemView.tvCapital.text = list[pos].capital
        holder.itemView.tvName.text = list[pos].name
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}

