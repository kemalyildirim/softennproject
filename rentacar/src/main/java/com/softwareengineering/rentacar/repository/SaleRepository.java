package com.softwareengineering.rentacar.repository;

import com.softwareengineering.rentacar.model.SaleClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SaleClass, Integer> {
}
