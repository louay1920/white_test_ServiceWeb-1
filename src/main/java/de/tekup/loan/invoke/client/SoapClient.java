package de.tekup.loan.invoke.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import de.tekup.loan.soap.api.consume.whitetest.StudentRequest;
import de.tekup.loan.soap.api.consume.whitetest.WhiteTestResponse;

@Service
public class SoapClient {
	
	private WebServiceTemplate serviceTemplate;
	
	@Autowired
	private Jaxb2Marshaller marshaller;
	
	public WhiteTestResponse getStatus(StudentRequest request)
	{
		serviceTemplate = new WebServiceTemplate(marshaller);
		WhiteTestResponse response = (WhiteTestResponse) serviceTemplate
				.marshalSendAndReceive("http://localhost:8081/ws", request);
		
		return response;
	}

}
