package com.example.shared

data class ServiceAudit(
    val serviceName: String,
    val traceId: String? = null,
)
