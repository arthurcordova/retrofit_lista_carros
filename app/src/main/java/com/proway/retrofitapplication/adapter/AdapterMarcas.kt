package com.proway.retrofitapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.proway.retrofitapplication.R
import com.proway.retrofitapplication.model.Marca

class AdapterMarcas : RecyclerView.Adapter<ViewHolderItemMarca>() {

    private var listDeMarcas: MutableList<Marca> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderItemMarca {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_marca, parent, false)
        return ViewHolderItemMarca(view)
    }

    override fun onBindViewHolder(holder: ViewHolderItemMarca, position: Int) {
        listDeMarcas[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int {
        return listDeMarcas.size
    }

    fun update(newList: List<Marca>) {
        listDeMarcas = mutableListOf()
        listDeMarcas.addAll(newList)
        notifyDataSetChanged()
    }
}

class ViewHolderItemMarca(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val codeTextView = itemView.findViewById<TextView>(R.id.codeTextView)
    private val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)

    fun bind(marca: Marca) {
        codeTextView.text = marca.id
        nameTextView.text = marca.name

    }
}