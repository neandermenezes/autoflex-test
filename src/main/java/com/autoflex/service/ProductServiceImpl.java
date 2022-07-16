package com.autoflex.service;

import com.autoflex.exceptions.ProductNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Inject ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  @Override
  public Product getProductById(Long id) throws ProductNotFoundException {
    return productRepository.findByIdOptional(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.listAll();
  }

  @Transactional
  @Override
  public Product updateProduct(Long id, Product product) throws ProductNotFoundException {
    Product existingProduct = getProductById(id);
    existingProduct.setName(product.getName());
    existingProduct.setValue(product.getValue());

    productRepository.persist(existingProduct);
    return existingProduct;
  }

  @Transactional
  @Override
  public Product saveProduct(Product product, List<Feedstock> feedstocks) {
    feedstocks.forEach((feedstock -> {
      product.addFeedstock(feedstock);
    }));
    productRepository.persistAndFlush(product);
    return product;
  }

  @Transactional
  @Override
  public void deleteProduct(Long id) throws ProductNotFoundException {
    productRepository.delete(getProductById(id));
  }
}
