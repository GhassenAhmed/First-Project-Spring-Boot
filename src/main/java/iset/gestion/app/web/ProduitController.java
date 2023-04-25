package iset.gestion.app.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

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
	public 	String getProduits(Model model ,
			@RequestParam(name="message",defaultValue = "") String message , @RequestParam(name="page",defaultValue ="0") int page
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
	public String save(@ModelAttribute("produit") @Valid Produit produit,BindingResult r,@RequestParam("photo") MultipartFile photo) throws ParseException, IOException{
		if(r.hasErrors()) {
			return("pages/produit/addProduit");
		}
		 
		 try {
				if(photo.getOriginalFilename()=="") {
					 return "pages/produit/addProduit";
				}
				produit.setPhoto_shema(photo.getOriginalFilename());
				produitService.addProduit(produit);
				String path_directory="C:\\Users\\ghass\\Documents\\workspace-spring-tool-suite-4-4.4.0.RELEASE\\Tp1-Spring-Boot-master\\src\\main\\resources\\static\\storage";
				Files.copy(photo.getInputStream(), Paths.get(path_directory+File.separator+photo.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			}catch(IOException e){
					System.out.println(""+e);
			}
		
		return "redirect:/produits?message=Add_Success";
	}
	
	@GetMapping(value="/delete")
	public String delete(String id) {
		
		produitService.deleteProduit(id);
		return "redirect:/produits?message=Delete_Success";
		
	}
	
	

	
	
	
	

}
