package com.kalimagezi.billionareskb.advert;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AdvertRepository extends CrudRepository<Advert, Integer> {


	List<Advert> findTop10ByEnabledTrue();

	List<Advert> findAllByEnabledFalse();

	List<Advert> findAllByEnabledTrue();

	List<Advert> findAllByEnabledTrueOrderByCreateDateDesc();

	void findAllByCid(int catid);

	List<Advert> findAllByEnabledTrueAndCidOrderByCreateDateDesc(int catid);

}
