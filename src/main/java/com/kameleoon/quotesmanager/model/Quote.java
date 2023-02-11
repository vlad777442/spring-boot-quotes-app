package com.kameleoon.quotesmanager.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "users")
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private Date createdAt;

    private Date updatedAt;


}
