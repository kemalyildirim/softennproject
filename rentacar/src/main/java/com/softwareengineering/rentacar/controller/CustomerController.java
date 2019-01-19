package com.softwareengineering.rentacar.controller;

import com.softwareengineering.rentacar.DAO.CustomerDAO;
import com.softwareengineering.rentacar.model.CustomerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerDAO dao;

    @PostMapping("/customer/save")
    public CustomerClass create(@Valid @RequestBody CustomerClass cus) {
        return dao.save(cus);
    }

    @GetMapping("/customer")
    public List<CustomerClass> getAll() {
        return dao.getAllCustomers();
    }

    // get last record by customerId
    @GetMapping("/customer/last")
    public List<CustomerClass> getLastCustomer(){
        return dao.getLastCustomer();
    }
}
