package com.chidubem.api.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val id: Int?,
    val image: String?,
    val ingredients: List<Ingredient>?,
    val name: String?,
    val servings: Int?,
    val steps: List<Step>?
): Parcelable{

    @Parcelize
    data class Ingredient(
        val ingredient: String?,
        val measure: String?,
        val quantity: Double?
    ): Parcelable

    @Parcelize
    data class Step(
        val description: String?,
        val id: Int?,
        val shortDescription: String?,
        val thumbnailURL: String?,
        val videoURL: String?
    ):Parcelable
}
