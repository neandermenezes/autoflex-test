package com.autoflex.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Feedstock {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Integer quantity;

  @ManyToMany(mappedBy = "feedstocks")
  private List<Product> products;
}
