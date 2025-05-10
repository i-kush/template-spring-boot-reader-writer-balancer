package com.kush.datasource.balancer.controller;

import com.kush.datasource.balancer.entity.Data;
import com.kush.datasource.balancer.service.DataService;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Data create() {
        return dataService.create();
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Data> get() {
        return dataService.findAll();
    }
}
