package iset.gestion.app.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor

public class Client implements Serializable {
	    @Id
		@GeneratedValue (strategy = GenerationType.AUTO)
		private long idclient;
		private String nom;
		private String adresse;
		@OneToMany(mappedBy = "Client")
		Collection<Produit> produits;
		
		
}
