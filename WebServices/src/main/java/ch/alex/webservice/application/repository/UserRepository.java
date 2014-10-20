package ch.alex.webservice.application.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.alex.webservice.application.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{

	public Collection<User> findByUsername(String username);
}
