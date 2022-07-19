package com.autoflex.service;

import com.autoflex.exceptions.ProductNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;

import java.util.List;

public interface ProductService {

  Product getProductById(Long id) throws ProductNotFoundException;

  List<Product> getAllProducts();

  Product updateProduct(Long id, Product product) throws ProductNotFoundException;

  Product saveProduct(Product product, List<Long> feedstockIds);

  void deleteProduct(Long id) throws ProductNotFoundException;

  void addFeedstockToProduct(Long productId, Long feedstockId);
}
