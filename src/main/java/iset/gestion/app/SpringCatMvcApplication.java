package iset.gestion.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import iset.gestion.app.dao.ProduitRepository;
import iset.gestion.app.entities.Produit;



@SpringBootApplication
public class SpringCatMvcApplication{
	
	public static void main(String[] args) {
		SpringApplication.run(SpringCatMvcApplication.class, args);
		
	}

	
}
