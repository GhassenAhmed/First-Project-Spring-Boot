package iset.gestion.app.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb.PageRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import iset.gestion.app.dao.ProduitRepository;
import iset.gestion.app.entities.Produit;
import iset.gestion.app.service.ProduitService;

@Controller
public class ProduitController {
	@Autowired
	ProduitRepository produitRepository;
	@Autowired ProduitService produitService;
	
	@GetMapping(value="/")
	 public String home() {
		return "pages/home";
	}
	
	@GetMapping(value="/produits")
	public 	String getProduits(Model model ,@RequestParam(name="message",defaultValue = "") String message , @RequestParam(name="page",defaultValue ="0") int page
			,@RequestParam(name="search",defaultValue = "") String search,@RequestParam(name="per_page",defaultValue="2") int size) {
		Page<Produit> produit=produitRepository.findByDesignationContains(search, PageRequest.of(page,size));
		int pageCount=produit.getTotalPages();
		int [] pages=new int[pageCount];
		for(int i=0;i<pageCount;i++) {
			pages[i]=i;
		}
		model.addAttribute("produits",produit);
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourant",page);
		model.addAttribute("message", message);
		model.addAttribute("search", search);
		model.addAttribute("size", size);
		return "pages/produit/produits";
	}
	
	@GetMapping(value="/addProduit")
	public String addProduit(Model model) {
		Produit produit = new Produit();
		model.addAttribute("produit", produit);
		return("pages/produit/addProduit");
	}
	
	@PostMapping(value="/produits")
	public String save(@ModelAttribute("produit") @Valid Produit produit,BindingResult r){
		if(r.hasErrors()) {
			return("pages/produit/addProduit");
		}
		 produitService.addProduit(produit);
		
		return "redirect:/produits?message=Add_Success";
	}
	
	@GetMapping(value="/delete")
	public String delete(String id) {
		
		produitService.deleteProduit(id);
		return "redirect:/produits?message=Delete_Success";
		
	}
	
	@GetMapping(value="/edit")
	public String edit(Model model,String id) {
		Produit produit= produitService.getById(id);
		model.addAttribute("produit", produit);
		return("pages/produit/edit");
	}

	
	
	
	

}
