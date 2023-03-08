package iset.gestion.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iset.gestion.app.dao.ProduitRepository;
import iset.gestion.app.entities.Produit;

@Service
public class ProduitService {
@Autowired
ProduitRepository produitRepository;


	public Produit addProduit(Produit p) {
		
		p=produitRepository.save(p);
		return p;
	}
	public Produit updateProduit(String reference,Produit p) {
		p.setReference(reference);
		p=produitRepository.save(p);
		return p;
	}
	
	public List <Produit> consultProduit() {
				return produitRepository.findAll();
	}	
	
	public void deleteProduit(String reference) {
		
		produitRepository.deleteById(reference);
	}
	
	@SuppressWarnings("deprecation")
	public Produit getById(String id) {
		return produitRepository.getById(id);
		}
}

