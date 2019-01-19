package com.softwareengineering.rentacar.controller;

import com.softwareengineering.rentacar.DAO.CarDAO;
import com.softwareengineering.rentacar.model.CarClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarDAO dao;

    @PostMapping("/car/save")
    public CarClass create(@Valid @RequestBody CarClass car) {return dao.save(car); }
    @GetMapping("/car")
    public List<CarClass> getAll(){ return dao.getAllCars(); }
    @GetMapping("/car/bybranch/{branch_id}")
    public List<CarClass> getCarsByBranch(@PathVariable(value = "branch_id") Integer branch_id){
        return dao.CarsByBranchId(branch_id);
    }
    @GetMapping("/car/{car_id}")
    public ResponseEntity<CarClass> getCarById(@PathVariable(value = "car_id") Integer car_id){
        CarClass car = dao.findOne(car_id);
        if(car == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(car);
    }
}

