package com.autoflex.service;

import com.autoflex.exceptions.FeedstockNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;

import java.util.List;

public interface FeedstockService {

  Feedstock getFeedstockById(Long id) throws FeedstockNotFoundException;

  List<Feedstock> getAllFeedstock();

  Feedstock updateFeedstock(Long id, Feedstock feedstock) throws FeedstockNotFoundException;

  Feedstock saveFeedstock(Feedstock feedstock);

  void deleteFeedstock(Long id) throws FeedstockNotFoundException;


  List<Object> getFeedstockProducts(Long id);
}
