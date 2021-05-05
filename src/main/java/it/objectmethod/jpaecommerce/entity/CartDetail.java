package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "carrello_dettaglio")
public class CartDetail {

	@Column(name = "id_carrello_dettaglio")
	@Id
	private Long id;

	@Column(name = "quantita")
	private Integer quantita;

	@ManyToOne
	@JoinColumn(name = "id_articolo")
	private Articles articleId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_carrello")
	private Articles cartId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantita() {
		return quantita;
	}

	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}

	public Articles getArticleId() {
		return articleId;
	}

	public void setArticleId(Articles articleId) {
		this.articleId = articleId;
	}

	public Articles getCartId() {
		return cartId;
	}

	public void setCartId(Articles cartId) {
		this.cartId = cartId;
	}

}
