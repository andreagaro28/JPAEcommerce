package it.objectmethod.jpaecommerce.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Cart;

@Repository
public interface CartDetailRepo extends JpaRepository<Cart, Long> {

	public List<Cart> findByCartId(Long cartId);
}
