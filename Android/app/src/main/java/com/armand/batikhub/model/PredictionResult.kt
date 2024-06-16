package com.armand.batikhub.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PredictionResult(
    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("percentage")
    val percentage: Int? = null,

    @field:SerializedName("label")
    val label: String? = null,

    @field:SerializedName("desc")
    val desc: String? = null
) : Serializable

data class PredictionResultResponse(
    @field:SerializedName("message")
    val message: String,

    @field:SerializedName("label")
    val label: String? = null,

    @field:SerializedName("percentage")
    val percentage: Int? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("desc")
    val desc: String? = null
) : Serializable