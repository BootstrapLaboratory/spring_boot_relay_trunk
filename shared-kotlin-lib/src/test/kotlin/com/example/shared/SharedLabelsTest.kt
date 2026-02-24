package com.example.shared

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SharedLabelsTest {
    @Test
    fun `service tag is predictable`() {
        assertEquals("spring-template:inventory-service", SharedLabels.serviceTag("inventory-service"))
    }
}
