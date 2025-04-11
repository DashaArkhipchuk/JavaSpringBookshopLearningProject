package com.coursework.bookshop.book.persistence;

import com.coursework.bookshop.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = "SELECT * FROM products WHERE authors_id = ?1", nativeQuery = true)
    List<Book> getBooksByAuthorsId(Integer authorsId);
}
