package com.uwaisalqadri.shared.domain.model

data class ApiError(
    val errors: List<String>
): Exception()
