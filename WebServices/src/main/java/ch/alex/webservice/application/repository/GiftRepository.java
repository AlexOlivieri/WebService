package ch.alex.webservice.application.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.alex.webservice.application.entity.Gift;

@Repository
public interface GiftRepository extends CrudRepository<Gift, Long>{

	public Collection<Gift> findByTitle(String title);
}
