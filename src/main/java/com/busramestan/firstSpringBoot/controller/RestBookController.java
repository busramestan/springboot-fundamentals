package com.busramestan.firstSpringBoot.controller;

import com.busramestan.firstSpringBoot.entity.Book;
import com.busramestan.firstSpringBoot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("rest/api/book")
public class RestBookController {
    private final BookService bookService;

    @PostMapping(path = "/save")
    public Book saveBook (@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @GetMapping(path = "/list")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }


}
