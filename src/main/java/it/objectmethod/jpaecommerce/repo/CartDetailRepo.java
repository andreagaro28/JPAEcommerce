package it.objectmethod.jpaecommerce.repo;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.CartDetail;

@Repository
public interface CartDetailRepo extends JpaRepository<CartDetail, Long> {

	public Optional<CartDetail> findByCartUserIdAndArticleId(Long userId, Long articleId);

	@Modifying
	@Transactional
	public void deleteByCartIdAndArticleId(Long cartId, Long articleId);

}
