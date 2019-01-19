package com.softwareengineering.rentacar.DAO;

import com.softwareengineering.rentacar.model.CustomerClass;
import com.softwareengineering.rentacar.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerDAO {

    @Autowired
    CustomerRepository cusRep;

    //Save
    public CustomerClass save(CustomerClass cus) {
        return cusRep.save(cus);
    }

    //Search
    public List<CustomerClass> getAllCustomers() {
        return cusRep.findAll();
    }
    public List<CustomerClass> getLastCustomer(){
        return cusRep.getLastCustomer();
    }

}
