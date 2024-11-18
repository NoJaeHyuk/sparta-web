package com.spartaweb.api.item.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ItemRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}