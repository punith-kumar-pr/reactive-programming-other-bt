package com.reactive.user.controllers;

import com.reactive.user.entity.Book;
import com.reactive.user.services.BookService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // create
    @PostMapping
    public Mono<Book> create(@RequestBody Book book) {
        return bookService.create(book);
    }

    // get all
    @GetMapping
    public Flux<Book> getAll() {
        return bookService.getAll();
    }

    // get one by id
    @GetMapping("/{id}")
    public Mono<Book> getById(@PathVariable int id) {
        return bookService.getById(id);
    }

    // update
    @PutMapping("/{id}")
    public Mono<Book> update(@RequestBody Book book, @PathVariable int id) {
        return bookService.update(id, book);
    }

    // delete
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable int id) {
        return bookService.delete(id);
    }

    // search
    @GetMapping("/search")
    public Flux<Book> searchBooks(@RequestParam("title") String title) {
        return bookService.getBookByTitle(title);
    }

}
