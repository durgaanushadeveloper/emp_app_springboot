package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.AddressDao;
import org.jsp.emp.entity.Address;
import org.jsp.emp.exceptionclasses.InvalidAddressIdException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressService {
	@Autowired
	private AddressDao dao;

	public Address saveAddress(Address address) {
		return dao.saveAddress(address);
	}

	public List<Address> findAddress() {
		return dao.findAddress();
	}

	public ResponseEntity<?> deleteAddressById(int id) {
		Optional<Address> address=dao.findAddressById(id);
		if(address.isEmpty())
			throw InvalidAddressIdException.builder().message("Invalid id").build();
		dao.deleteAddressById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address found successfully").body("deleted successfully").build());
	}

}
