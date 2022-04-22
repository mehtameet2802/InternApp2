package com.example.intern

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class rv_adapter(var data:List<TheProject>):RecyclerView.Adapter<rv_adapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.rv_card,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(v: View):RecyclerView.ViewHolder(v){
        var id = v.findViewById<TextView>(R.id.rv_id)
        var any = v.findViewById<TextView>(R.id.rv_text)
        fun bind(d:TheProject){
            id.text = d.code.toString()
            any.text = d.anything
        }
    }
}