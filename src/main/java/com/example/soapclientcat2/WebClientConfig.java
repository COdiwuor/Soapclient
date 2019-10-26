package com.example.soapclientcat2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebClientConfig {
    @Bean
    public Jaxb2Marshaller marshaller(){
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    //Note! this package must match the package in the <generatePackage>
    marshaller.setContextPath("localhost.university");
    return marshaller;
    }

    @Bean
    public Client quoteClient(Jaxb2Marshaller marshaller){
    Client client = new Client();
    client.setDefaultUri("http://localhost/university");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
    }

}
