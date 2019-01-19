package com.softwareengineering.rentacar.DAO;

import com.softwareengineering.rentacar.model.CarClass;
import com.softwareengineering.rentacar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDAO {
    @Autowired
    CarRepository carRep;

    public CarClass save(CarClass car) { return carRep.save(car); }
    public List<CarClass> getAllCars() { return carRep.findAll(); }
    public CarClass findOne(Integer carId) { return carRep.findById(carId).orElse(null); }
    public List<CarClass> CarsByBranchId(Integer branch_id){
        return carRep.findCarByBranchId(branch_id);
    }
}
