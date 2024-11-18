package com.spartaweb.api.item.controller;

import com.spartaweb.api.item.controller.dto.ItemRequestDto;
import com.spartaweb.api.item.controller.dto.ItemUpdateDto;
import com.spartaweb.api.item.service.ItemService;
import com.spartaweb.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/post")
@RestController
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody ItemRequestDto request) {
        return ResponseEntity.ok(itemService.createItem(request));
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @PutMapping("/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable("itemId") Long itemId, @RequestBody ItemUpdateDto updatedItem) {
        return ResponseEntity.ok(itemService.updateItem(itemId, updatedItem));
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable("itemId") Long id) {
        String message = itemService.deleteItem(id);
        return ResponseEntity.ok().body(message);
    }
}
