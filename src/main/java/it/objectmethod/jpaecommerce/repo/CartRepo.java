package it.objectmethod.jpaecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart, Long> {

	public Cart findByUserIdId(Long userId);

}
