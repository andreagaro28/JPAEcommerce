package it.objectmethod.jpaecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.dto.LoginDto;
import it.objectmethod.jpaecommerce.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

	@Query(value = "SELECT new it.objectmethod.jpaecommerce.dto.LoginDto(u.id, u.userName, u.password) FROM Login u WHERE u.userName = ?1 AND u.password = ?2")
	public Optional<LoginDto> getUserDto(String name, String password);

}
