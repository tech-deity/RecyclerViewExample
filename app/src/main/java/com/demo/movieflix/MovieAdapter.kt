package com.demo.movieflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val items:ArrayList<String>, private val listener:MovieItemClicked):RecyclerView.Adapter<MovieViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view =LayoutInflater.from(parent.context).inflate(R.layout.item_movie,parent,false)
        val viewHolder=MovieViewHolder(view)
        view.setOnClickListener {
            listener.onItemClicked(items[viewHolder.adapterPosition])
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentPosition =items[position]
        holder.titleView.text=currentPosition
    }

    override fun getItemCount(): Int {
       return items.size
    }

}

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val titleView:TextView=itemView.findViewById(R.id.title)


}

interface MovieItemClicked{

    fun onItemClicked(item:String)
}