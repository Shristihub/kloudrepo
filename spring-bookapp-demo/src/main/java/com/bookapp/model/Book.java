package com.bookapp.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private String title;
    private Integer bookId;
    private String author;
    private double price;
    private String category;
}
