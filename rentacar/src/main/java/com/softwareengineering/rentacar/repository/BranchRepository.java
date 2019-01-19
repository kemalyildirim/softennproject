package com.softwareengineering.rentacar.repository;

import com.softwareengineering.rentacar.model.BranchClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BranchRepository extends JpaRepository<BranchClass, Integer> {
    List<BranchClass> findBranchByCityId(Integer id);
}
