package com.busramestan.firstSpringBoot.service;

import com.busramestan.firstSpringBoot.entity.Book;
import com.busramestan.firstSpringBoot.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book saveBook (Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
