package com.chidubem.api.network

import com.chidubem.api.model.Recipe
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://d17h27t6h515a5.cloudfront.net/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .baseUrl(BASE_URL)
    .build()

interface ApiService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getRecipe(): ArrayList<Recipe>

    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getIngredient(): ArrayList<Recipe.Ingredient>

    @GET("topher/2017/May/59121517_baking/baking.json")
    suspend fun getSteps(): ArrayList<Recipe.Step>
}

object RecipeApi {
    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}