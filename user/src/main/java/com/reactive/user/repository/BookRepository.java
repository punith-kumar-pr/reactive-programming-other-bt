package com.reactive.user.repository;

import com.reactive.user.entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveCrudRepository<Book, Integer> {

    @Query("select * from book_details where book_name like :title")
    Flux<Book> findBookByTitle(String s);
}
