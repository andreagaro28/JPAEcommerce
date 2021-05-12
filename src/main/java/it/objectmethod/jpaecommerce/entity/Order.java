package it.objectmethod.jpaecommerce.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ordine")
@Data
public class Order {

	@Id
	@GeneratedValue
	@Column(name = "id_ordine")
	private Long id;

	@Column(name = "numero_ordine")
	private String numOrder;

	@Column(name = "data_ordine")
	private LocalDate date;

	@OneToMany
	@JoinColumn(name = "id_ordine")
	private List<OrderRow> orderList;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Login user;
}
