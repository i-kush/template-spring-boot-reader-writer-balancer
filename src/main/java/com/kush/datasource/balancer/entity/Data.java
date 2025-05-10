package com.kush.datasource.balancer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Data {
    @Id
    public String id;
    public String data;

    public Data() {
    }

    public Data(String id, String data) {
        this.id = id;
        this.data = data;
    }
}
