package iset.gestion.app.dao;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import iset.gestion.app.entities.Client;
import iset.gestion.app.entities.Produit;


@RestResource
public interface ClientRepository extends JpaRepository<Client,Long> {
	
	/*public Page<Client> findByDesignationContains(String mc,Pageable pageable);*/
}
