package iset.gestion.app.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iset.gestion.app.dao.ClientRepository;
import iset.gestion.app.entities.Client;

@Service
public class ClientService {
@Autowired
ClientRepository clientRepository;

//affiche
public List <Client> ConsultClients (){
	return clientRepository.findAll();
}
//add 
public Client addClient(Client c) {
	c=clientRepository.save(c);
	return c;
}

//update
public Client updateClient(long id,Client c) {
	c.setIdclient(id);
	return c=clientRepository.save(c);
}

//delete
public void deleteClient(long id,Client c) {
	clientRepository.deleteById(id);
}

}
