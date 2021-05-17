package it.objectmethod.jpaecommerce.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.CartDetail;

@Repository
public interface CartDetailRepo extends JpaRepository<CartDetail, Long> {

	public Optional<CartDetail> findByCartUserIdIdAndArticleIdId(Long userId, Long articleId);

	@Modifying
	@Transactional
	@Query(value = "delete from CartDetail cd where cd.cart.id = ?1 and cd.articleId.id = ?2")
	public void deleteArticleInCart(Long cartId, Long articleId);

	@Modifying
	@Transactional
	public void deleteByCartIdAndArticleIdId(Long cartId, Long articleId);

}
