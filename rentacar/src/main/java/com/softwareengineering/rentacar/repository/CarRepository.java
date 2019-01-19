package com.softwareengineering.rentacar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.softwareengineering.rentacar.model.CarClass;

import java.util.List;

public interface CarRepository extends JpaRepository<CarClass, Integer> {
    List<CarClass> findCarByBranchId(Integer id);

}
