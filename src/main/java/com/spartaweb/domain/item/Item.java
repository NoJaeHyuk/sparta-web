package com.spartaweb.domain.item;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private boolean deleted = false; // 삭제 플래그 (기본값: false)

    @Builder
    private Item(String title, String content, int price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public void update(String title, String content, int price, String username) {
        this.title = title;
        this.content = content;
        this.price = price;
        this.username = username;
    }

    public void markAsDeleted() {
        this.deleted = true;
    }
}
