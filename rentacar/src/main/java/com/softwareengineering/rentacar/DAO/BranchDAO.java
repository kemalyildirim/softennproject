package com.softwareengineering.rentacar.DAO;

import com.softwareengineering.rentacar.model.BranchClass;
import com.softwareengineering.rentacar.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchDAO {
    @Autowired
    BranchRepository branchRep;

    public BranchClass save(BranchClass branch) { return branchRep.save(branch); }
    public List<BranchClass> getAllBranches() { return branchRep.findAll(); }

    public List<BranchClass> BranchesByCityId(Integer city_id){
        return branchRep.findBranchByCityId(city_id);
    }
}
