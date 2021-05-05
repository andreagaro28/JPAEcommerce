package it.objectmethod.jpaecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "utente")
public class Login {

	@Column(name = "id_utente")
	@Id
	private Long id;
	@Column(name = "nome_utente")
	private String userName;
	@Column(name = "password")
	private String password;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_utente", referencedColumnName = "id_utente")
	private Cart cart;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
