package com.autoflex.controller;

import com.autoflex.dto.ProductDto;
import com.autoflex.exceptions.ProductNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/product")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductController {

  private final ProductService productService;

  @Inject
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GET
  public List<Product> getProducts() {
    return productService.getAllProducts();
  }

  @GET
  @Path("/{id}")
  public Product getProduct(@PathParam("id") Long id) throws ProductNotFoundException {
    return productService.getProductById(id);
  }

  @POST
  public Product createProduct(@Valid ProductDto productDto) {
    return productService.saveProduct(productDto.toProduct(), productDto.getFeedstockIds());
  }

  @PUT
  @Path("/{id}")
  public Product updateProduct(
      @PathParam("id") Long id,
      @Valid ProductDto productDto
  ) throws ProductNotFoundException {
    return productService.updateProduct(id, productDto.toProduct());
  }

  @DELETE
  @Path("/{id}")
  public Response deleteProduct(@PathParam("id") Long id) throws ProductNotFoundException {
    productService.deleteProduct(id);
    return Response.status(Response.Status.NO_CONTENT).build();
  }

  @POST
  @Path("/{product_id}/feedstock/{feedstock_id}")
  public Response addFeedstockToProduct(@PathParam("product_id") Long productId, @PathParam("feedstock_id") Long feedstockId) {
    productService.addFeedstockToProduct(productId, feedstockId);
    return Response.ok().build();
  }
}
