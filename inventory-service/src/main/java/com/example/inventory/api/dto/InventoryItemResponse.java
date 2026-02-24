package com.example.inventory.api.dto;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryItemResponse {

    private Long id;
    private String sku;
    private String name;
    private Integer quantity;
    private Instant createdAt;
    private String serviceTag;
}
