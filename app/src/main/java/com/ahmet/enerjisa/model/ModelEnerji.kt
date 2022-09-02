package com.ahmet.enerjisa.model

data class MenuResponse(
    val isMaintenance: Boolean?,
    val errorCode: Int?,
    val errorMessage: String?,
    val logUrl: String?,
    val requestId: String?,
    val result: Result?,
    val sid: String?,
    val statusCode: Int?,
    val validationErrorMessages: String?
)

data class Result(
    val isSuccess: Boolean,
    val message: String,
    val errorCode: Int,
    val requestContextID: String,
    val resultObject: List<ResultObject>
)

data class ResultObject(
    val key: Int,
    val value: String
)


