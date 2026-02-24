package com.example.inventory.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateInventoryItemRequest {

    @NotBlank
    @Size(max = 64)
    private String sku;

    @NotBlank
    @Size(max = 128)
    private String name;

    @NotNull
    @Min(0)
    private Integer quantity;
}
