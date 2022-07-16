package com.autoflex.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String name;

  private Integer valor;

  @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinTable(name = "product_feedstock",
    joinColumns = {@JoinColumn(name = "product_id")},
    inverseJoinColumns = {@JoinColumn(name = "feedstock_id")})
  private List<Feedstock> feedstocks;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getValor() {
    return valor;
  }

  public void setValor(Integer valor) {
    this.valor = valor;
  }

  public List<Feedstock> getFeedstocks() {
    return feedstocks;
  }

  public void setFeedstocks(List<Feedstock> feedstocks) {
    this.feedstocks = feedstocks;
  }
}
