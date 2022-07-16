package com.autoflex.dto;

import com.autoflex.model.Product;

import javax.validation.constraints.NotBlank;

public class ProductDto {

  private String name;

  private Integer valor;

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

  public Product toProduct() {
    Product product = new Product();
    product.setName(name);
    product.setValor(valor);

    return product;
  }
}
