package it.objectmethod.jpaecommerce.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.objectmethod.jpaecommerce.entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {

	public Optional<Login> findByUserNameAndPassword(String userName, String password);

}
