package com.autoflex.service;

import com.autoflex.exceptions.FeedstockNotFoundException;
import com.autoflex.model.Feedstock;
import com.autoflex.model.Product;
import com.autoflex.repository.FeedstockRepository;
import com.autoflex.result.FeedstockWithProductsResult;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@ApplicationScoped
public class FeedstockServiceImpl implements FeedstockService {

  private final FeedstockRepository feedstockRepository;

  private final EntityManager em;

  @Inject
  public FeedstockServiceImpl(FeedstockRepository feedstockRepository, EntityManager em) {
    this.feedstockRepository = feedstockRepository;
    this.em = em;
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

  @Override
  public List<Object> getFeedstockProducts(Long id) {
    Query query = em.createNativeQuery("SELECT PF.feedstock_id, PF.product_id FROM feedstock AS F\n" +
        "\tJOIN product_feedstock as PF\n" +
        "    ON F.id = PF.feedstock_id\n" +
        "    AND PF.feedstock_id = :id");

    query.setParameter("id", id);

    return query.getResultList();
  }
}
