package com.developerxgroup.medicinehistory.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/groups")
    List<String> groups() {
        List<String> l = new ArrayList<>();
        l.add("QQQQQQQQQQQQQ");
        l.add("WWWWWWWWWWWWW");
        l.add("EEEEEEEEEEEEE");
        return l;
    }

}
