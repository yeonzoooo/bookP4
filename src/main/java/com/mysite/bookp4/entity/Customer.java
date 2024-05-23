package com.mysite.bookp4.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String author;

  private String category;

  @Column(nullable = false)
  private boolean available;

  // Getters and setters
}
