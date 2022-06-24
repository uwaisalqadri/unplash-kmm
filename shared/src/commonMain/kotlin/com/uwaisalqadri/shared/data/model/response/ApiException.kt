package com.uwaisalqadri.shared.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiException(
    @SerialName("errors")
    val errors: List<String>? = null
): Exception()
