package com.coursework.bookshop.author.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Table(name = "authors")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="biography")
    private String biography;
    @Column(name="activity_years")
    private String activityYears;
}
