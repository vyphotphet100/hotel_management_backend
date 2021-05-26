package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
