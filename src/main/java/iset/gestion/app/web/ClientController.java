package iset.gestion.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iset.gestion.app.dao.ClientRepository;
import iset.gestion.app.entities.Client;
import iset.gestion.app.entities.Produit;
import iset.gestion.app.service.ClientService;

@Controller
public class ClientController {
	@Autowired ClientRepository clientRepository;
	@Autowired ClientService clientService;
	
	/*@GetMapping(value="/clients")
	public 	String getClients(Model model ,@RequestParam(name="message",defaultValue = "") String message , @RequestParam(name="page",defaultValue ="0") int page
			,@RequestParam(name="search",defaultValue = "") String search,@RequestParam(name="per_page",defaultValue="2") int size) {
		Page<Client> client=clientRepository.findByDesignationContains(search, PageRequest.of(page,size));
		int pageCount=client.getTotalPages();
		int [] pages=new int[pageCount];
		for(int i=0;i<pageCount;i++) {
			pages[i]=i;
		}
		model.addAttribute("clients",client);
		model.addAttribute("pages",pages);
		model.addAttribute("pageCourant",page);
		model.addAttribute("message", message);
		model.addAttribute("search", search);
		model.addAttribute("size", size);
		return "pages/client/clients";
	}*/
	
	@GetMapping(value="/Clients")
	public String consult(Model model) {
		List<Client> client;
		client=clientService.consultClient();
		model.addAttribute("client",client);
		
		return"pages/client/clients";
	}
	
	@GetMapping(value="/deleteClient")
	public String deleteClient(long id) {
		clientService.deleteClient(id);
		return "redirect:/clients";
	}
	
	
	@GetMapping(value="/editClient")
	public String getClient(Model model,long id) {
		Client c = clientService.getClient(id);
		model.addAttribute("client", c);
		return"pages/client/edit";
	}
	@PostMapping(value="/addClient")
	public String addClient(@ModelAttribute("client") Client client) {
		clientService.addClient(client);
		return"clients";
	}
	
}
