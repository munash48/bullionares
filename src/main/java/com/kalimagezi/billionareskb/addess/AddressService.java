package com.kalimagezi.billionareskb.addess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.counter.Counter;
import com.kalimagezi.billionareskb.counter.CounterService;


@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CounterService counterService;
	

	public String addAddress(Address address) {
		JSONObject jsonObject = new JSONObject();
		
		Counter counter =counterService.getUCounter(address.getUid());

		addressRepository.save(address);
		
		try {
			jsonObject.put("message", address.getStreet()+" Updated successfully");
			jsonObject.put("noVotes", counter.getNoVotes());
			jsonObject.put("noTVotes", counter.getTotal());
			jsonObject.put("newAddress", address.getCountry()+", "+address.getDistrict()+", " +address.getDivision());
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
