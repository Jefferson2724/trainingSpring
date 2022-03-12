package com.algaworks.algalog.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.client.Client;
import com.algaworks.algalog.client.ClientDTO;
import com.algaworks.algalog.client.ClientRepository;
import com.algaworks.algalog.client.ClientService;
import com.algaworks.algalog.exceptions.APIException;


@RestController
@RequestMapping(path = "/api/v1/client", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping()
	public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO clientBody){
		
		ClientDTO response = this.clientService.create(clientBody);
		
		return new ResponseEntity<ClientDTO>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody ClientDTO clientDTO){
		
		Integer bodyId = clientDTO.getId();
		
		if(bodyId == null || !id.equals(bodyId)) {
			throw new APIException("Verifique o id informado e tente novamente mais tarde !", HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(this.clientService.update(clientDTO), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		ClientDTO client = this.clientService.getClientById(id);
		
		if(client == null) {
			throw new APIException("Cliente Não existe", HttpStatus.NOT_FOUND);
		}
		
		this.clientRepository.deleteById(id.longValue());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/{clientId}")
	public ResponseEntity<?> getClient(@PathVariable Integer clientId){
		return new ResponseEntity<>(this.clientService.getClientById(clientId), HttpStatus.OK);
	}
	
	@GetMapping("/listClient")
	public List<Client> listClient() {
		return clientRepository.findAll();
	}
	
}
