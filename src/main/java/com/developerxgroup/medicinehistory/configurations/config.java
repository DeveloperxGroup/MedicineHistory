package com.developerxgroup.medicinehistory.configurations;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.*;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
public class config{
    @Value("${elasticsearch.host:localhost}")
    public String host;
    @Value("${elasticsearch.port:9300}")
    public int port;
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }
    @Bean

    public Client client(){
        TransportClient client = null;
        try{
            System.out.println("host:"+ host+"port:"+port);
            client = new PreBuiltTransportClient(Settings.EMPTY)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"), 9300));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}