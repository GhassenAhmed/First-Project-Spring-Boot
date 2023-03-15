package iset.gestion.app.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import iset.gestion.app.entities.Produit;
import iset.gestion.app.service.ProduitService;

@RestController
public class ProduitRestController {
	@Autowired
	ProduitService produitService;
	
	@PostMapping("/addProduit")
	public Produit addProduit(@RequestBody Produit p) {
		return produitService.addProduit(p);
	}
	
	
	
	@GetMapping("/consultProduit")
	public List<Produit> consultProduit() {
		List <Produit> p;
		 p=produitService.consultProduit();
		 return p;
	}
	
	@DeleteMapping("/deleteProduit")
	public void deleteProduit(String reference) {
		produitService.deleteProduit(reference);
	}

}
