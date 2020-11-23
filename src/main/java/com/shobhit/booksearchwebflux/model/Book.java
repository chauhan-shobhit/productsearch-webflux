package com.shobhit.booksearchwebflux.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Book {

  @Id
  private String Id;
  private String title;
  private String author;
  private float rating;
  private Double price;
  private String format;

}
