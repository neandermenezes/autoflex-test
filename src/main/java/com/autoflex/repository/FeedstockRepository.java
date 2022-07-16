package com.autoflex.repository;

import com.autoflex.model.Feedstock;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FeedstockRepository implements PanacheRepository<Feedstock> {
}
