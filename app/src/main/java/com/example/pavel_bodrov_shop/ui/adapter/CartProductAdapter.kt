package com.example.pavel_bodrov_shop.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Product
import kotlinx.android.synthetic.main.item_product.view.*

class CartProductAdapter (
    private val onDeleteClick: (product: Product) -> Unit,
    private val onProductClick: (product: Product) -> Unit
): RecyclerView.Adapter<CartProductAdapter.ViewHolder>() {

    private var products = listOf<Product>()

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            Glide
                .with(itemView)
                .load(product.imageUrl)
                .error(R.mipmap.ic_launcher)
                .into(itemView.cartProductIv)
            itemView.cartProductNameTv.text = product.name
            itemView.cartProductPriceTv.text = "${product.price/1000} т.р."

            itemView.deleteProductIv.setOnClickListener{
                onDeleteClick(product)
            }

            itemView.setOnClickListener {
                onProductClick(product)
            }
        }
    }

}