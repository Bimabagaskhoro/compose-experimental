package com.bimabk.experimental.api.core.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailResponse(
    @SerialName("aw")
    val aw: String?
)
