package tum.hackatum.orderbookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tum.hackatum.orderbookservice.model.OrderBook;

public interface OrderBookRepository extends JpaRepository<OrderBook, Long> {



}
