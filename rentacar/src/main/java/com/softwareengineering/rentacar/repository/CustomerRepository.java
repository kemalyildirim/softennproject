package com.softwareengineering.rentacar.repository;

import com.softwareengineering.rentacar.model.CustomerClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerClass, Integer> {
    @Query(value = "SELECT * FROM customer_table ORDER BY id DESC LIMIT 1", nativeQuery = true)
    List<CustomerClass> getLastCustomer();
}
