package com.example.soapclientcat2;

import localhost.university.GetUniversityRequest;
import localhost.university.GetUniversityResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class Client extends WebServiceGatewaySupport {


    public GetUniversityResponse getUniversityResponseResponse(String universityname) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(universityname);


        GetUniversityResponse response = (GetUniversityResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:7000/university",
                        request,
                        new SoapActionCallback("http://localhost:7000/university"));

        return response;
    }

}
