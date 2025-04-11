package com.coursework.bookshop.author.persistence;

import com.coursework.bookshop.author.entity.Author;
import com.coursework.bookshop.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<Author> findByFirstNameAndLastName(String firstName, String lastName);

//    @Query("select * from authors where a.last_name = :lastname and not a.first_name = :firstname")
//    List<Author> findByLastNameAndNotByFirstName(String firstname, String lastname);
}
