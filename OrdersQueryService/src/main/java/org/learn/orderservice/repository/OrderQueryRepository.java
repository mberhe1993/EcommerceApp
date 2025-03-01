package org.learn.orderservice.repository;

import org.learn.orderservice.model.OrderQuery;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderQueryRepository extends MongoRepository<OrderQuery, String> {
    Optional<OrderQuery> findByOrderNumber(String orderNumber);
}
