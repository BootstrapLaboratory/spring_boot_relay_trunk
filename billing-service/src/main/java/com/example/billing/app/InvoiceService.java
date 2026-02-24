package com.example.billing.app;

import com.example.billing.api.InvoiceMapper;
import com.example.billing.api.dto.CreateInvoiceRequest;
import com.example.billing.api.dto.InvoiceResponse;
import com.example.billing.domain.InvoiceRecord;
import com.example.billing.infra.InvoiceRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository repository;
    private final InvoiceMapper mapper;

    @Transactional
    public InvoiceResponse create(CreateInvoiceRequest request) {
        InvoiceRecord invoiceRecord = mapper.toEntity(request);
        invoiceRecord.setStatus("PENDING");

        InvoiceRecord saved = repository.save(invoiceRecord);
        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<InvoiceResponse> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
