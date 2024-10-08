package org.jsp.emp.controller;

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
@RequestMapping("/addresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/{aid}")
	public ResponseEntity<?> saveAddress(@PathVariable int aid,@RequestBody Address address){
		return addressService.saveAddress(aid,address);
	}
	
	@GetMapping
	public ResponseEntity<?> findAllAddress(){
		return addressService.findAllAddress();
	}
	
	@GetMapping("/{aid}")
	public ResponseEntity<?> findAddressById(@PathVariable long aid){
		return addressService.findAddressById(aid);
	}
	@GetMapping("/employee/{eid}")
	public ResponseEntity<?> findAddressByEmployeeId(@PathVariable long eid){
		return addressService.findAddressByEmployeeId(eid);
	}
	
	
	@DeleteMapping("/{aid}")
	public ResponseEntity<?> deleteAddressById(@PathVariable long aid){
		return addressService.deleteAddressById(aid);
	}

}
