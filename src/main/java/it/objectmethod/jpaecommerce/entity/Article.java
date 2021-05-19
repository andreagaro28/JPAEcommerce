package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "articolo")
@Data
public class Article {

	@Column(name = "id_articolo")
	@GeneratedValue
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

}
