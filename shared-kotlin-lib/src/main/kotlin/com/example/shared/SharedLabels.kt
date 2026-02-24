package com.example.shared

object SharedLabels {
    @JvmStatic
    fun serviceTag(serviceName: String): String = "spring-template:$serviceName"
}
