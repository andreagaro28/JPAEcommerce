package it.objectmethod.jpaecommerce.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "articolo")
public class Articles {

	@Column(name = "id_articolo")
	@Id
	private Long id;
	@Column(name = "nome_articolo")
	private String name;
	@Column(name = "disponibilita")
	private Integer available;
	@Column(name = "codice_articolo")
	private String articleCode;
	@Column(name = "prezzo_unitario")
	private Double price;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "carrello_dettaglio", joinColumns = @JoinColumn(name = "id_articolo", referencedColumnName = "id_articolo"), inverseJoinColumns = @JoinColumn(name = "id_carrello", referencedColumnName = "id_carrello"))
	private List<Cart> cart;

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAvailable() {
		return available;
	}

	public void setAvailable(Integer available) {
		this.available = available;
	}

	public String getArticleCode() {
		return articleCode;
	}

	public void setArticleCode(String articleCode) {
		this.articleCode = articleCode;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
