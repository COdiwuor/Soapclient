package com.example.soapclientcat2;

import localhost.university.GetUniversityRequest;
import localhost.university.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {


    public GetUniversityResponse getUniversityResponseResponse(String countryname) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(countryname);


        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost/university",
                        request,
                        new SoapActionCallback("http://localhost/university"));

        return response;
    }

}
