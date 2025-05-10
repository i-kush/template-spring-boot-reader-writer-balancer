package com.kush.datasource.balancer.repository;

import com.kush.datasource.balancer.entity.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<Data, String> {
}
