package com.example.pavel_bodrov_shop.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pavel_bodrov_shop.R
import com.example.pavel_bodrov_shop.domain.model.Product
import kotlinx.android.synthetic.main.catalog_lv_product.view.*

class LastViewedAdapter (
    private val onProductClick: (product: Product) -> Unit
): RecyclerView.Adapter<LastViewedAdapter.ViewHolder>() {

    private var products = listOf<Product>()

    fun setData(products: List<Product>) {
        this.products = products
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastViewedAdapter.ViewHolder =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.catalog_lv_product, parent, false))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: LastViewedAdapter.ViewHolder, position: Int) {
        holder.bind(products[position])
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(product: Product) {
            itemView.catalogLvProductNameTv.text = product.productName
            itemView.catalogLvProductPriceTv.text = "%.2f Р".format(product.discountPrice)

            itemView.setOnClickListener {
                onProductClick(product)
            }
        }
    }

}