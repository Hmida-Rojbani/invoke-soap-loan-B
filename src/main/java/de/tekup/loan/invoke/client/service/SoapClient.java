package de.tekup.loan.invoke.client.service;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.loan.soap.api.consume.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.api.consume.loaneligebilty.WsResponse;

@Service
public class SoapClient {
	
	private WebServiceTemplate serviceTemplate;
	
	private Jaxb2Marshaller marshaller;
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		WebServiceTemplate serviceTemplate = new WebServiceTemplate(marshaller);
		
		WsResponse response = (WsResponse) serviceTemplate.
				marshalSendAndReceive("http://localhost:8080/ws", request);
		
		return response;
	}

}
