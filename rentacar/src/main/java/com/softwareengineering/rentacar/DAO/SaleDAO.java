package com.softwareengineering.rentacar.DAO;


import com.softwareengineering.rentacar.model.SaleClass;
import com.softwareengineering.rentacar.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleDAO {
    @Autowired
    SaleRepository saleRep;

    //Save
    public SaleClass save(SaleClass sale) {
        return saleRep.save(sale);
    }

    //Search
    public List<SaleClass> getAllSales() {
        return saleRep.findAll();
    }


}
