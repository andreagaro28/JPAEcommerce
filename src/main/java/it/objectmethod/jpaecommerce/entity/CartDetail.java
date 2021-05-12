package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "carrello_dettaglio")
@Data
public class CartDetail {

	@Column(name = "id_carrello_dettaglio")
	@Id
	private Long id;

	@Column(name = "quantita")
	private Integer quantita;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_articolo")
	private Articles articleId;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_carrello")
	private Cart cart;

}
