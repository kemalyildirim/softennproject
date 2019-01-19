package com.softwareengineering.rentacar.controller;

import com.softwareengineering.rentacar.DAO.SaleDAO;
import com.softwareengineering.rentacar.model.SaleClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SaleController {
    @Autowired
    SaleDAO dao;

    @PostMapping("/sale/save")
    public SaleClass create(@Valid @RequestBody SaleClass sale) {
        return dao.save(sale);
    }

    @GetMapping("/sale")
    public List<SaleClass> getAll() {
        return dao.getAllSales();
    }
}