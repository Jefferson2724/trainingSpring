package com.algaworks.algalog.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algalog.client.model.ClientModel;

@RestController
public class ClienteController {

	@GetMapping("/client")
	public List<ClientModel> listClient() {
		ClientModel client1 = new ClientModel();
		client1.setId(1L);
		client1.setName("Rodrigao");
		client1.setPhonenumber("+55 81 98547-3364");
		client1.setEmail("rodrigo@gmail.com");
		
		ClientModel client2 = new ClientModel();
		client2.setId(1L);
		client2.setName("cezao");
		client2.setPhonenumber("+55 25 92344-3364");
		client2.setEmail("cezaro@gmail.com");

		return Arrays.asList(client1, client2);
	}
}
