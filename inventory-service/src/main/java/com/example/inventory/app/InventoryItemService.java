package com.example.inventory.app;

import com.example.inventory.api.InventoryItemMapper;
import com.example.inventory.api.dto.CreateInventoryItemRequest;
import com.example.inventory.api.dto.InventoryItemResponse;
import com.example.inventory.domain.InventoryItem;
import com.example.inventory.infra.InventoryItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryItemService {

    private final InventoryItemRepository repository;
    private final InventoryItemMapper mapper;

    @Transactional
    public InventoryItemResponse create(CreateInventoryItemRequest request) {
        repository.findBySku(request.getSku()).ifPresent(item -> {
            throw new DuplicateSkuException(item.getSku());
        });

        InventoryItem saved = repository.save(mapper.toEntity(request));
        return mapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public List<InventoryItemResponse> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"))
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}
