package com.example.inventory.api;

import com.example.inventory.api.dto.CreateInventoryItemRequest;
import com.example.inventory.api.dto.InventoryItemResponse;
import com.example.inventory.domain.InventoryItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InventoryItemMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    InventoryItem toEntity(CreateInventoryItemRequest request);

    @Mapping(
            target = "serviceTag",
            expression = "java(com.example.shared.SharedLabels.serviceTag(\"inventory-service\"))"
    )
    InventoryItemResponse toResponse(InventoryItem item);
}
