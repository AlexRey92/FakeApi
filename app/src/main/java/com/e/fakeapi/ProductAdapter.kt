package com.e.fakeapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter:ListAdapter<ProductsOb,ProductAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(private val view: View):RecyclerView.ViewHolder(view) {

        private val idProducto:TextView = view.findViewById(R.id.textViewID)
        private val tituloProducto:TextView = view.findViewById(R.id.textViewproducto)
        private val precioProducto:TextView = view.findViewById(R.id.textViewprecio)

        fun onBind(producto:ProductsOb){
            idProducto.text = producto.ID.toString()
            tituloProducto.text = producto.titulo
            precioProducto.text = producto.precio.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<ProductsOb>() {
        override fun areItemsTheSame(oldItem: ProductsOb, newItem: ProductsOb): Boolean {
            return oldItem.ID == newItem.ID
        }

        override fun areContentsTheSame(oldItem: ProductsOb, newItem: ProductsOb): Boolean {
            return oldItem == newItem
        }
    }
}
