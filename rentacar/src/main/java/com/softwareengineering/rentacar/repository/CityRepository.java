package com.softwareengineering.rentacar.repository;

import com.softwareengineering.rentacar.model.CityClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<CityClass, Integer> {
    
}
