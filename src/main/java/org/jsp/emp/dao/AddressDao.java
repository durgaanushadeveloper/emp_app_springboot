package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Address;
import org.jsp.emp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressDao {
	
	@Autowired
	private AddressRepository repository;

	public Address saveAddress(Address address) {
		// TODO Auto-generated method stub
		return repository.save(address);
	}

	public List<Address> findAddress() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void deleteAddressById(int id) {
		repository.deleteById(id);;
	}

	public Optional<Address> findAddressById(int id) {
		return repository.findById(id);
	}

}
