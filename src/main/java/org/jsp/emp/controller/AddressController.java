package org.jsp.emp.controller;

import java.util.List;

import org.jsp.emp.entity.Address;
import org.jsp.emp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService service;
	
	@PostMapping
	public Address saveAddress(@RequestBody Address address)
	{
		return service.saveAddress(address);
	}
	
	@GetMapping
	public List<Address> findAddress()
	{
		return service.findAddress();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddressById(@PathVariable int id)
	{
		return service.deleteAddressById(id);
	}

}
