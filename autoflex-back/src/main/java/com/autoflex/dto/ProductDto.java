package com.autoflex.dto;

import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class ProductDto {

  private String name;

  private Integer value;

  private List<Feedstock> feedstocks = new ArrayList<>();

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

  public Product toProduct() {
    Product product = new Product();
    product.setName(name);
    product.setValue(value);
    product.setFeedstocks(feedstocks);

    return product;
  }
}
