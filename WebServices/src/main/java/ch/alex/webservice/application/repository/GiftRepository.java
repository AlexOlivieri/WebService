package ch.alex.webservice.application.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface GiftRepository extends CrudRepository<Gift, Long>{

	public Collection<Gift> findByName(String name);
}
