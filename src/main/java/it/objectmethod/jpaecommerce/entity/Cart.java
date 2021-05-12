
package it.objectmethod.jpaecommerce.entity;

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
@Table(name = "carrello")
@Data
public class Cart {

	@GeneratedValue
	@Id
	@Column(name = "id_carrello")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Login userId;

//	@ManyToMany
//	@JoinTable(name = "carrello_dettaglio", joinColumns = @JoinColumn(name = "id_carrello"), inverseJoinColumns = @JoinColumn(name = "id_articolo"))
//	private List<Articles> articleList;

	@OneToMany
	@JoinColumn(name = "id_carrello")
	private List<CartDetail> cartList;

}
