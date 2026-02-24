package com.example.billing.api;

import com.example.billing.api.dto.CreateInvoiceRequest;
import com.example.billing.api.dto.InvoiceResponse;
import com.example.billing.domain.InvoiceRecord;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InvoiceMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    InvoiceRecord toEntity(CreateInvoiceRequest request);

    @Mapping(
            target = "serviceTag",
            expression = "java(com.example.shared.SharedLabels.serviceTag(\"billing-service\"))"
    )
    InvoiceResponse toResponse(InvoiceRecord record);
}
