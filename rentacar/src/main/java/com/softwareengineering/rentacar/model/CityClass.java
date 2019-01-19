package com.softwareengineering.rentacar.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.repository.query.Param;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;


@Entity
@Table(name = "CityTable")
@EntityListeners(AuditingEntityListener.class)
public class CityClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String city_name;

    public String getCity_name() {
        return city_name;
    }

    public CityClass(){

    }

    public CityClass(String city_name){
        this.city_name = city_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }
}
