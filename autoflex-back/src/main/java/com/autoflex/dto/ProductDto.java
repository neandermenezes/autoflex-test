package com.autoflex.dto;

import com.autoflex.model.Product;

import javax.validation.constraints.NotBlank;

public class ProductDto {

  private String name;

  private Integer value;

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

  public Product toProduct() {
    Product product = new Product();
    product.setName(name);
    product.setValue(value);

    return product;
  }
}
