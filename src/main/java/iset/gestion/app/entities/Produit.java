package iset.gestion.app.entities;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Produit implements Serializable {
	@Id
	@NotBlank(message="required reference !")
	private String reference;
	
	@NotBlank(message="required designation !")
	private String designation;
	
	
	private double prix;
	private int quantite;
	
	@Column(columnDefinition = "longtext")
	private String photo_shema;
	@ManyToOne
	@JoinColumn(name="codeClient")
	Client Client;
	

	/*public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public void setPhoto_shema(String originalFilename) {
		this.photo_shema=originalFilename;
		
	}
	
	
	
	


}
