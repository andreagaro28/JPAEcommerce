package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "riga_ordine")
@Data
public class OrderRow {

	@Id
	@GeneratedValue
	@Column(name = "id_riga_ordine")
	private Long id;

	@Column(name = "id_ordine")
	private Long orderId;

	@Column(name = "quantita")
	private Integer quantity;

	@OneToOne
	@JoinColumn(name = "id_articolo")
	private Articles article;
}
