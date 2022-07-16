package com.autoflex.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Product {

  public Product(String name, Integer value) {
    this.name = name;
    this.value = value;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank
  @Size(max = 256)
  private String name;

  @NotBlank
  @Size(min = 0)
  private Integer value;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "product_feedstock",
    joinColumns = {@JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn(name = "feedstock_id")})
  private List<Feedstock> feedstocks;

  public Product() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getValue() {
    return value;
  }

  public void setValue(Integer value) {
    this.value = value;
  }

  public List<Feedstock> getFeedstocks() {
    return feedstocks;
  }

  public void setFeedstocks(List<Feedstock> feedstocks) {
    this.feedstocks = feedstocks;
  }
}
