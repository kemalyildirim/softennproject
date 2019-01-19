package com.softwareengineering.rentacar.controller;


import com.softwareengineering.rentacar.DAO.BranchDAO;
import com.softwareengineering.rentacar.model.BranchClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BranchController {
    @Autowired
    BranchDAO dao;

    @PostMapping("/branch/save")
    public BranchClass create(@Valid @RequestBody BranchClass branch) {return dao.save(branch); }
    @GetMapping("/branch")
    public List<BranchClass> getAll(){ return dao.getAllBranches(); }
    @GetMapping("/branch/{id}")
    public List<BranchClass> getBranches(@PathVariable(value = "id") Integer city_id){
        return dao.BranchesByCityId(city_id);

    }
}
