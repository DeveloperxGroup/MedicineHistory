package com.developerxgroup.medicinehistory.controller;

import com.developerxgroup.medicinehistory.model.*;
import com.developerxgroup.medicinehistory.service.*;
import org.elasticsearch.action.delete.*;
import org.elasticsearch.action.get.*;
import org.elasticsearch.action.index.*;
import org.elasticsearch.action.search.*;
import org.elasticsearch.action.update.*;
import org.elasticsearch.client.*;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.*;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@RestController
@RequestMapping("/api")
public class TestController {
    @Autowired
    Client client;
    @Autowired
    UsersService usersService;
    @GetMapping("/getUserByID/{id}")
    public ResponseEntity getUserByID(@PathVariable String id) {
        try {
            System.out.println("***********************  "+usersService.findAll());
            Users users = usersService.findUsersByID(Integer.parseInt(id));
            if (users != null) {
                return new ResponseEntity<>(users, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("INVALID_COUNTRY_CODE", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/updateUser")
    public ResponseEntity updateUser(@Valid @RequestBody  Users user) throws IOException {
        try {
            Users users = usersService.updateser(user);
            if (users != null) {
                return new ResponseEntity<>(users, HttpStatus.CREATED);
            }
            return new ResponseEntity<>("FAILED TO UPDATE", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception ex) {
            Logger.getLogger(TestController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("INTERNAL_ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/create")
    public String create(@RequestBody Users user) throws IOException {
        IndexResponse response = client.prepareIndex("users", "employee", user.getId()+"")
                .setSource(jsonBuilder()
                                .startObject()
                                .field("name", user.getFname())
//                        .field("userSettings", user.getUserSettings())
                                .endObject()
                )
                .get();
        System.out.println("response id:"+response.getId());
        return response.getResult().toString();
    }
    @GetMapping("/view/{id}")
    public Map<String, Object> view(@PathVariable final String id) {
        GetResponse getResponse = client.prepareGet("users", "employee", id).get();
        return getResponse.getSource();
    }
    @GetMapping("/view/name/{field}")
    public Map<String, Object> searchByName(@PathVariable final String field) {
        Map<String,Object> map = null;
        SearchResponse response = client.prepareSearch("users")
                .setTypes("employee")
                .setSearchType(SearchType.QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.matchQuery("name", field))
                                .get()
        ;
        List<SearchHit> searchHits = Arrays.asList(response.getHits().getHits());
        map =   searchHits.get(0).getSourceAsMap();
        return map;
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable final String id) throws IOException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("users")
                .type("employee")
                .id(id)
                .doc(jsonBuilder()
                        .startObject()
                        .field("name", "Rajesh")
                        .endObject());
        try {
            UpdateResponse updateResponse = client.update(updateRequest).get();
            System.out.println(updateResponse.status());
            return updateResponse.status().toString();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e);
        }
        return "Exception";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable final String id) {
        DeleteResponse deleteResponse = client.prepareDelete("users", "employee", id).get();
        return deleteResponse.getResult().toString();
    }
}
