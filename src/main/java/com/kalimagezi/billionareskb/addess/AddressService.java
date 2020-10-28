package com.kalimagezi.billionareskb.addess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public String addAddress(Address address) {
		JSONObject jsonObject = new JSONObject();

		addressRepository.save(address);
		
		try {
			jsonObject.put("message", address.getStreet()+" Updated successfully");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject.toString();
	}

	public Optional<Address> getAddress(int id) {

		return addressRepository.findById(id);

	}
	public Optional<Address> getUAddress(int id) {

		return addressRepository.findByUid(id);

	}

	public List<Address> getAllAddresses() {

		List<Address> addresses = new ArrayList<>();
		addressRepository.findAll().forEach(addresses::add);
		return addresses;

	}

	public void updateAddress(Address address) {

		addressRepository.save(address);
	}

	public void deleteAddress(int id) {
		addressRepository.deleteById(id);

	}

}
