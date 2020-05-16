package com.example.pavel_bodrov_shop.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Category(
    val id: String,
    val name: String
) : Parcelable