package it.objectmethod.jpaecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.OrderRow;

@Repository
public interface OrderRowRepo extends JpaRepository<OrderRow, Long> {

}
