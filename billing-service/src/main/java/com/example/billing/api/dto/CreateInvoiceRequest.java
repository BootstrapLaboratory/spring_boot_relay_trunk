package com.example.billing.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInvoiceRequest {

    @Email
    @NotBlank
    private String customerEmail;

    @NotNull
    @DecimalMin(value = "0.01")
    private BigDecimal amount;
}
