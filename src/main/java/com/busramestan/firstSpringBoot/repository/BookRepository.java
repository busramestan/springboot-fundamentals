package com.busramestan.firstSpringBoot.repository;

import com.busramestan.firstSpringBoot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
