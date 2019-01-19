package com.softwareengineering.rentacar.controller;

import com.softwareengineering.rentacar.DAO.CityDAO;
import com.softwareengineering.rentacar.model.CityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController{
    @Autowired
    CityDAO dao;

    @PostMapping("/city/save")
    public CityClass create(@Valid @RequestBody CityClass city) { return dao.save(city); }
    @GetMapping("/city")
    public List<CityClass> getAll() { return dao.getAllCities(); }
}
