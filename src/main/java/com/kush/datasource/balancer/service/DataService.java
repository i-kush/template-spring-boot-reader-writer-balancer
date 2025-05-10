package com.kush.datasource.balancer.service;

import com.kush.datasource.balancer.entity.Data;
import com.kush.datasource.balancer.repository.DataRepository;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Transactional
    public Data create() {
        return dataRepository.save(new Data(UUID.randomUUID().toString(), Instant.now().toString()));
    }

    @Transactional(readOnly = true)
    public List<Data> findAll() {
        return dataRepository.findAll();
    }


}
