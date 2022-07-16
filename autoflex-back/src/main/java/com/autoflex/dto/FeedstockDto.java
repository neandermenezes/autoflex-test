package com.autoflex.dto;

import com.autoflex.model.Feedstock;

import javax.validation.constraints.NotBlank;

public class FeedstockDto {

  private String name;

  private Integer quantity;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Feedstock toFeedstock() {
    Feedstock feedstock = new Feedstock();
    feedstock.setName(name);
    feedstock.setQuantity(quantity);

    return feedstock;
  }
}
