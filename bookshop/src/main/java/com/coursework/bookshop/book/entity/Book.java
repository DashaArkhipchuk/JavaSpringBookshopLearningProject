package com.coursework.bookshop.book.entity;

import com.coursework.bookshop.author.entity.Author;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "products")
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(
//        name="Book.findCheapBooks",
//        query = "select from Book where price< :price"
//)
public class Book {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="year_of_publishing")
    private int publishYear;
    @Column(name="genre")
    private String genre;
    @Column(name="price")
    private Double price;

    @ManyToOne(targetEntity = Author.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "authors_id")
    private Author author;
}
