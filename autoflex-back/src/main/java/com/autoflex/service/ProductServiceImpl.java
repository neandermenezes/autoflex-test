package com.autoflex.service;

import com.autoflex.exceptions.ProductNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.repository.FeedstockRepository;
import com.autoflex.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  private final FeedstockRepository feedstockRepository;

  @Inject ProductServiceImpl(ProductRepository productRepository, FeedstockRepository feedstockRepository) {
    this.feedstockRepository = feedstockRepository;
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
  public Product saveProduct(Product product, List<Long> feedstockIds) {
    List<Feedstock> feedstocks = feedstockIds.stream().map((id) -> feedstockRepository.findById(id)).collect(Collectors.toList());

    feedstocks.forEach((feedstock -> product.addFeedstock(feedstock)));

    productRepository.persist(product);
    return product;
  }

  @Transactional
  @Override
  public void deleteProduct(Long id) throws ProductNotFoundException {
    productRepository.delete(getProductById(id));
  }

  @Transactional
  @Override
  public void addFeedstockToProduct(Long productId, Long feedstockId) {
    Product product = productRepository.findById(productId);
    Feedstock feedstock = feedstockRepository.findById(feedstockId);

    System.out.println(product.getName() + " " + feedstock.getName());

    product.addFeedstock(feedstock);

    productRepository.persist(product);
  }
}
