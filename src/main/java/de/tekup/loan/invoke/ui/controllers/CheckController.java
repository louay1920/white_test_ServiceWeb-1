package de.tekup.loan.invoke.ui.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.client.SoapClient;
import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;

@Controller
public class CheckController {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/student")
	public String checkStudentForm(Model model)
	{
		StudentRequest request = new StudentRequest();
		model.addAttribute("request", request);
		request.setStudentId(1);
		
		System.out.println("****" + request.getStudentId());
		System.out.println("****"+ request.getExamCode());
		return "request";
	}
	
	
	@PostMapping("/check/student")
	public String checkResults(@ModelAttribute("request") StudentRequest request, Model model)
	{
		WhiteTestResponse response = client.getStatus(request);
		model.addAttribute("response", response);
		return "results";
	}

}
