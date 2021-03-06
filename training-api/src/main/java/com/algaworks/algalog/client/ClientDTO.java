package com.algaworks.algalog.client;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_EMPTY)
public class ClientDTO {
	
	private Integer id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String email;
	
	private String phonenumber;

	public ClientDTO(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.phonenumber = client.getPhonenumber();
	}
	
}
