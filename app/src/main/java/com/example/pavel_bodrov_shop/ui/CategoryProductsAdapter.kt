package com.example.pavel_bodrov_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Product
import kotlinx.android.synthetic.main.category_products_item.view.*

class CategoryProductsAdapter(
    private val onProductClick: (product: Product) -> Unit
): RecyclerView.Adapter<CategoryProductsAdapter.ViewHolder>() {
    private var products = listOf<Product>()

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryProductsAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_products_item, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: CategoryProductsAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            Glide
                .with(itemView)
                .load(product.imageUrl)
                .error(R.mipmap.ic_launcher)
                .into(itemView.categoryProductsItemIv)
            itemView.categoryProductsItemNameTv.text = product.name
            itemView.categoryProductsItemPriceTv.text = "${product.price} Р"

            itemView.setOnClickListener {
                onProductClick(product)
            }
        }
    }
}