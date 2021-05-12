package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "utente")
@Data
public class Login {

	@Column(name = "id_utente")
	@Id
	private Long id;
	@Column(name = "nome_utente")
	private String userName;
	@Column(name = "password")
	private String password;

}
