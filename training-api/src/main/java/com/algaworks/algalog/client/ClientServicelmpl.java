package com.algaworks.algalog.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.algaworks.algalog.exceptions.APIException;

@Service
public class ClientServicelmpl implements ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public ClientDTO create(ClientDTO clientBody) {
		Client client = this.clientRepository.save(this.toJPA(clientBody));
		
		return this.toDTO(client);
	}
	
	public Client toJPA(ClientDTO client) {
		Long clientId = client.getId() != null ? client.getId().longValue() : null;
		
		return Client.builder()
				.id(clientId)
				.name(client.getName())
				.email(client.getEmail())
				.phonenumber(client.getPhonenumber())
				.build();
	}
	
	public ClientDTO toDTO(Client client) {
		ClientDTO clientDTO = new ClientDTO(client);
		
		return clientDTO;
	}
	
	@Override
	public ClientDTO getClientById(Integer clientId) {
		Optional<Client> client = this.clientRepository.findById(clientId.longValue());
		
		if(client.isEmpty()) {
			throw new APIException("Cliente não existe !", HttpStatus.NOT_FOUND);
		}
		
		return this.toDTO(client.orElse(null));
	}
	
	@Override
	public ClientDTO update(ClientDTO clientDTO) {
		Optional<Client> client = this.clientRepository.findById(clientDTO.getId().longValue());
		
		if(client.isEmpty()) {
			throw new APIException("Cliente não existe !", HttpStatus.NOT_FOUND);
		}
		
		Client newClient = this.clientRepository.saveAndFlush(this.toJPA(clientDTO));
		
		return this.toDTO(newClient);
	}
}
