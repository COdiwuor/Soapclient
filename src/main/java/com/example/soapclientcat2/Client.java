package com.example.soapclientcat2;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import universities.wsdl.*;

public class Client extends WebServiceGatewaySupport {


    public GetUniversityResponse getUniversityResponse (String universityname) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(universityname);

        return (GetUniversityResponse) getWebServiceTemplate().marshalSendAndReceive("http://localhost:7000/ws/universities",request);
    }

    public GetAllUniversitiesAtLocationResponse getAllUniversitiesAtLocationResponse (String location){

        GetAllUniversitiesAtLocationRequest request = new GetAllUniversitiesAtLocationRequest();
        request.setLocation(location);

        return (GetAllUniversitiesAtLocationResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:7000/ws/universities",request);
    }

    public GetAllUniversitiesResponse  getAllUniversitiesResponse (){
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();
        return (GetAllUniversitiesResponse)getWebServiceTemplate().marshalSendAndReceive("http://localhost:7000/ws/universities",request);
    }

}
