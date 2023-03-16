package iset.gestion.app.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iset.gestion.app.dao.ClientRepository;
import iset.gestion.app.entities.Client;

@Service
public class ClientService {
@Autowired ClientRepository clientRepository;

public Client addClient(Client c) {
	c=clientRepository.save(c);
	return c;
}

public List<Client> consultClient(){
	return clientRepository.findAll();
}

public void deleteClient(long id) {
	clientRepository.deleteById(id);
}


public Client updateClient(long id,Client c) {
	c.setIdclient(id);
	return clientRepository.save(c);
}

public Client getClient(long id) {
	@SuppressWarnings("deprecation")
	Client c=clientRepository.getById(id);
	return c;
}
}