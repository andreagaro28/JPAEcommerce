package it.objectmethod.jpaecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "carrello")
public class Cart {

	@Id
	@Column(name = "id_carrello")
	private Long cartId;
	@Column(name = "id_utente")
	private Long userId;

	@ManyToMany
	@JoinTable(name = "carrello_dettaglio", joinColumns = @JoinColumn(name = "id_carrello", referencedColumnName = "id_carrello"), inverseJoinColumns = @JoinColumn(name = "id_articolo", referencedColumnName = "id_articolo"))
	private List<Articles> articlesLIst;

	public List<Articles> getArticlesLIst() {
		return articlesLIst;
	}

	public void setArticlesLIst(List<Articles> articlesLIst) {
		this.articlesLIst = articlesLIst;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
