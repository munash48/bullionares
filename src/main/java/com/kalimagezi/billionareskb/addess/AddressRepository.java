package com.kalimagezi.billionareskb.addess;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address,Integer> {

	Optional<Address> findByUid(int id);

}
