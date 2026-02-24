package com.example.inventory.api;

import com.example.inventory.api.dto.CreateInventoryItemRequest;
import com.example.inventory.api.dto.InventoryItemResponse;
import com.example.inventory.app.InventoryItemService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory/items")
@RequiredArgsConstructor
public class InventoryItemController {

    private final InventoryItemService service;

    @GetMapping
    public List<InventoryItemResponse> listItems() {
        return service.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryItemResponse createItem(@Valid @RequestBody CreateInventoryItemRequest request) {
        return service.create(request);
    }
}
