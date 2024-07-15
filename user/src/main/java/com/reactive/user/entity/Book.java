package com.reactive.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("book_details")
public class Book {

    @Id
    @Column("book_id")
    private int bookId;

    @Column("book_name")
    private String bookName;

    @Column("book_desc")
    private String description;

    private String publisher;
    private String author;

}
