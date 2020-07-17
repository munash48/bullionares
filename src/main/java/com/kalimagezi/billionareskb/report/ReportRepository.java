package com.kalimagezi.billionareskb.report;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ReportRepository extends CrudRepository<Report, Integer> {

	List<Report> findAllByUid(int uid);

	List<Report> findAllByAid(Integer aid);

}
