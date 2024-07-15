package com.reactive.user.services;

import com.reactive.user.entity.Book;
import com.reactive.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Mono<Book> create(Book book) {
        return bookRepository.save(book);
    }

    public Flux<Book> getAll() {
        Flux<Book> allBooks = bookRepository.findAll();
        return allBooks;
    }


    public Mono<Book> getById(int id) {
        Mono<Book> byId = bookRepository.findById(id);
        return byId;
    }


    public Mono<Book> update(int id, Book book) {
        Mono<Book> oldBook = bookRepository.findById(id);
        return oldBook.flatMap(book1 -> {
                book1.setBookName(book.getBookName());
                book1.setAuthor(book.getAuthor());
                book1.setPublisher(book.getPublisher());
                book1.setDescription(book.getDescription());
            return bookRepository.save(book1);
        });
    }

    public Mono<Void> delete(int id) {
        return bookRepository.deleteById(id);
    }

    public Flux<Book> getBookByTitle(String title) {
        return bookRepository.findBookByTitle("%" + title + "%");
    }

    public Flux<Book> getBookByAuthor(String author) {
        return bookRepository.findBookByTitle("%" + author + "%");
    }
}
