package com.example.quotes_app_k

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Quotes_list_adapter (val context:Context, val list: List<QuotesResponses>): RecyclerView.Adapter<Quotes_viewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Quotes_viewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_quote, parent , false)
        return Quotes_viewHolder(layout)
    }

    override fun onBindViewHolder(holder: Quotes_viewHolder, position: Int) {
        holder.quotes.text = list.get(position).text
        holder.author.text = list.get(position).text
    }

    override fun getItemCount(): Int {
        return list.size
    }


}

class Quotes_viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var quotes: TextView = itemView.findViewById(R.id.title_id)
    var author: TextView = itemView.findViewById(R.id.author_id)
    var copy: TextView = itemView.findViewById(R.id.copy_id)

}