package com.armand.batikhub.model

import com.google.gson.annotations.SerializedName

data class DetailBatik(

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("regional_origin")
	val regionalOrigin: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("id")
	val id: String? = null
)

data class DetailBatikResponse(
	val message: String,
	val data: DetailBatik
)
