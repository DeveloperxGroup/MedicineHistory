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
import java.util.logging.*;

@Configuration
public class config{
    @Value("${elasticsearch.host:178.238.234.27}")
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
            Logger.getAnonymousLogger().log(Level.ALL,"Elastic Search Client");
            System.out.println("Elastic Search Client");
            Settings settings = Settings.builder()
//                    .put("client.transport.nodes_sampler_interval", "5s")
//                    .put("client.transport.sniff", false)
//                    .put("transport.tcp.compress", true)
                    .put("cluster.name", "docker-cluster")
//                    .put("request.headers.X-Found-Cluster", "${cluster.name}")
                    .build();
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new TransportAddress(InetAddress.getByName("178.238.234.27"), 9300));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }

}