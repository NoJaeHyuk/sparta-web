package com.spartaweb.api.item.service;

import com.spartaweb.api.item.controller.dto.ItemRequestDto;
import com.spartaweb.api.item.controller.dto.ItemUpdateDto;
import com.spartaweb.domain.item.Item;
import com.spartaweb.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@RequiredArgsConstructor
@Component
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public Item createItem(ItemRequestDto request) {
        Item item = Item.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .price(request.getPrice())
                .username(request.getUsername())
                .build();
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        // 삭제되지 않은 데이터만 반환
        return itemRepository.findAllActiveItems();
    }

    @Transactional
    public Item updateItem(Long id, ItemUpdateDto updatedItem) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("item not found!!"));
        item.update(updatedItem.getTitle(), updatedItem.getContent(), updatedItem.getPrice(), updatedItem.getUsername());
        return item;
    }

    @Transactional
    public String deleteItem(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("삭제할 데이터가 없습니다."));
        item.markAsDeleted();
        return "삭제 완료";
    }
}
