package com.kalimagezi.billionareskb.report;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ReportControllerApi {

	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("/reports")
	public List<Report> getAllReports(){
		return reportService.getAllReports();
	}
	@RequestMapping("/report/{id}")
	public Optional<Report> getReport(@PathVariable int id){
		return reportService.getReport(id);
	}
	@RequestMapping(method=RequestMethod.POST ,value="/report")
	public void addReport(@RequestBody Report report ){
		reportService.addReport(report);;
	}
	@RequestMapping(method=RequestMethod.PUT ,value="/report/{id}")
	public void updateReport(@RequestBody Report report, @PathVariable int id){
		reportService.updateReport(report);
	}
	@RequestMapping(method=RequestMethod.DELETE,value="/report/{id}")
	public void deleteReport(@PathVariable int id ){
		reportService.deleteReport(id);
	}
}
