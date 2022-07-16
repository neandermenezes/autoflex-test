package com.autoflex.controller;

import com.autoflex.dto.FeedstockDto;
import com.autoflex.dto.ProductDto;
import com.autoflex.exceptions.FeedstockNotFoundException;
import com.autoflex.exceptions.ProductNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.service.FeedstockService;
import com.autoflex.service.ProductService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@ApplicationScoped
@Path("/feedstock")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FeedstockController {

  private final FeedstockService feedstockService;

  @Inject
  public FeedstockController(FeedstockService feedstockService) {
    this.feedstockService = feedstockService;
  }

  @GET
  public List<Feedstock> getFeedstocks() {
    return feedstockService.getAllFeedstock();
  }

  @GET
  @Path("/{id}")
  public Feedstock getFeedstock(@PathParam("id") Long id) throws FeedstockNotFoundException {
    return feedstockService.getFeedstockById(id);
  }

  @POST
  public Feedstock createFeedstock(@Valid FeedstockDto feedstockDto) {
    return feedstockService.saveFeedstock(feedstockDto.toFeedstock());
  }

  @PUT
  @Path("/{id}")
  public Feedstock updateFeedstock(@PathParam("id") Long id, @Valid FeedstockDto feedstockDto) throws FeedstockNotFoundException {
    return feedstockService.updateFeedstock(id, feedstockDto.toFeedstock());
  }

  @DELETE
  @Path("/{id}")
  public Response deleteProduct(@PathParam("id") Long id) throws FeedstockNotFoundException {
    feedstockService.deleteFeedstock(id);
    return Response.status(Response.Status.NO_CONTENT).build();
  }
}