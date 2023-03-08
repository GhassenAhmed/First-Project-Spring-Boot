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
@Data  @AllArgsConstructor @NoArgsConstructor 
public class Client implements Serializable {
	    @Id
		@GeneratedValue (strategy = GenerationType.AUTO)
		private long idclient;
		private String nom;
		private String adresse;
		@OneToMany(mappedBy = "Client")
		Collection<Produit> produits;
		public Client(long idclient, String nom, String adresse, Collection<Produit> produits) {
			super();
			this.idclient = idclient;
			this.nom = nom;
			this.adresse = adresse;
			this.produits = produits;
		}
		public long getIdclient() {
			return idclient;
		}
		public void setIdclient(long idclient) {
			this.idclient = idclient;
		}
		
		
}
