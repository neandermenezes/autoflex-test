package com.autoflex.service;

import com.autoflex.exceptions.FeedstockNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.repository.FeedstockRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class FeedstockServiceImpl implements FeedstockService {

  private final FeedstockRepository feedstockRepository;

  @Inject
  public FeedstockServiceImpl(FeedstockRepository feedstockRepository) {
    this.feedstockRepository = feedstockRepository;
  }

  @Override
  public Feedstock getFeedstockById(Long id) throws FeedstockNotFoundException {
    return feedstockRepository.findByIdOptional(id).orElseThrow(() -> new FeedstockNotFoundException("feedstock not found"));
  }

  @Override
  public List<Feedstock> getAllFeedstock() {
    return feedstockRepository.listAll();
  }

  @Transactional
  @Override
  public Feedstock updateFeedstock(Long id, Feedstock feedstock) throws FeedstockNotFoundException {
    Feedstock existingFeedstock = getFeedstockById(id);
    existingFeedstock.setName(existingFeedstock.getName());
    existingFeedstock.setQuantity(existingFeedstock.getQuantity());

    feedstockRepository.persist(existingFeedstock);
    return existingFeedstock;
  }

  @Transactional
  @Override
  public Feedstock saveFeedstock(Feedstock feedstock) {
    feedstockRepository.persistAndFlush(feedstock);
    return feedstock;
  }

  @Transactional
  @Override
  public void deleteFeedstock(Long id) throws FeedstockNotFoundException {
    feedstockRepository.delete(getFeedstockById(id));
  }
}
