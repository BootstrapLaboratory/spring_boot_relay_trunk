package com.example.billing.infra;

import com.example.billing.domain.InvoiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceRecord, Long> {
}
