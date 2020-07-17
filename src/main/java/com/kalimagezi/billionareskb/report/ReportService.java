package com.kalimagezi.billionareskb.report;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kalimagezi.billionareskb.report.Report;
import com.kalimagezi.billionareskb.report.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;

	public void addReport(Report report) {

		reportRepository.save(report);
	}

	public Optional<Report> getReport(int id) {

		return reportRepository.findById(id);

	}

	public List<Report> getAllReports() {

		List<Report> reports = new ArrayList<>();
		reportRepository.findAll().forEach(reports::add);
		return reports;

	}

	public void updateReport(Report report) {

		reportRepository.save(report);
	}

	public void deleteReport(int id) {
		reportRepository.deleteById(id);

	}

	public List<Report> getAllReportsByUid(int uid) {
		// TODO Auto-generated method stub
		return reportRepository.findAllByUid(uid);
	}

	public List<Report> getAllReportsByAid(Integer aid) {
		// TODO Auto-generated method stub
		return reportRepository.findAllByAid(aid);
	}


}
