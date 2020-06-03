package com.os.sliderdemo.apiutils.requestModel

data class ClickResponse(
    val `data`: Data,
    val errCode: Int,
    val msg: String,
    val status: Int
)