package org.learn.orderservice.repository;

import org.learn.orderservice.model.OrderCommand;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderCommandRepository  extends MongoRepository<OrderCommand, String> {
    Optional<OrderCommand> findByOrderNumber(String orderNumber);
}
