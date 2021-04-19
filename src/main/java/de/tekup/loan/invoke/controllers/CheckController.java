package de.tekup.loan.invoke.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.tekup.loan.invoke.client.service.SoapClient;
import de.tekup.loan.soap.api.consume.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.api.consume.loaneligebilty.WsResponse;

@Controller
public class CheckController {
	
	@Autowired
	private SoapClient client;
	
	@GetMapping("/check/customer")
	public String customerForm(Model model) {
		CustomerRequest request = new CustomerRequest();
		model.addAttribute("request", request);
		return "request";
	}
	
	@PostMapping("/check/customer")
	public String customerCheck(@ModelAttribute("request") CustomerRequest request, Model model) {
		//invoke de service web
		WsResponse response = client.getLoanStatus(request);
		model.addAttribute("response", response);
		return "response";
	}

}
