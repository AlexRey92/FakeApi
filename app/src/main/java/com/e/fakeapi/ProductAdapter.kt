package com.e.fakeapi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter:ListAdapter<ProductsOb,ProductAdapter.ViewHolder>(DiffCallBack) {
    inner class ViewHolder(val view:View):RecyclerView.ViewHolder(view){
        private val Idproducto:TextView=view.findViewById(R.id.textViewID)
        private val TituloProducto:TextView=view.findViewById(R.id.textViewproducto)
        private val PrecioProducto:TextView=view.findViewById(R.id.textViewprecio)

        fun onBind(producto:ProductsOb){
            Idproducto.text=producto.ID.toString()
            TituloProducto.text=producto.titulo
            PrecioProducto.text=producto.precio.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.item_task,parent,false)
        return ViewHolder((view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=getItem(position)
        holder.onBind(item)
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
