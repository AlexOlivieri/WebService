package ch.alex.webservice.application.repository;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ch.alex.webservice.application.entity.GiftChain;
import ch.alex.webservice.application.entity.User;

@Repository
public interface ChainRepository extends CrudRepository<GiftChain, Long>{

	public Collection<GiftChain> findByTitle(String title);
}
