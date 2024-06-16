package com.armand.batikhub.api

import com.armand.batikhub.model.Batik
import com.armand.batikhub.PredictionResultActivity
import com.armand.batikhub.model.BatikResponse
import com.armand.batikhub.model.DetailBatik
import com.armand.batikhub.model.DetailBatikResponse
import com.armand.batikhub.model.PredictionResult
import com.armand.batikhub.model.PredictionResultResponse
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Body
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.Part

interface BatikApi {
    @GET("/batik")
    fun getAllBatik(): Call<BatikResponse>

    @GET("/batik/id/{id}")
    fun getBatikById(@Path("id") id: String): Call<DetailBatikResponse>

    @POST("batik/name")
    fun getBatikByName(@Body requestBody: Map<String, String>): Call<BatikResponse>

    @Multipart
    @POST("/predict")
    fun predictImage(@Part image: MultipartBody.Part): Call<PredictionResultResponse>
}