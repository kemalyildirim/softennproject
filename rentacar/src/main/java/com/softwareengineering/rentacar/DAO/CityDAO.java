package com.softwareengineering.rentacar.DAO;

import com.softwareengineering.rentacar.model.CityClass;
import com.softwareengineering.rentacar.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityDAO{
    @Autowired
    CityRepository cityRep;

    public CityClass save(CityClass city) { return cityRep.save(city); }
    public List<CityClass> getAllCities() { return cityRep.findAll(); }

    //Custom queries

}
