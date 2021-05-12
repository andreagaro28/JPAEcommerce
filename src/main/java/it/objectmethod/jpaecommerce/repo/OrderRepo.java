package it.objectmethod.jpaecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Order;
import it.objectmethod.jpaecommerce.entity.OrderRow;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

	public List<Order> findByUserId(Long userId);

	public OrderRow findByNumOrder(String numOrder);

}
