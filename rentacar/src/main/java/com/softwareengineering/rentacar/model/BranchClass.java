package com.softwareengineering.rentacar.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name = "BranchTable")
@EntityListeners(AuditingEntityListener.class)
public class BranchClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String branch_name;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private CityClass city;

    public CityClass getCity() {
        return city;
    }

    public BranchClass(){ }

    public BranchClass(Integer branch_id){
        this.id = branch_id;
    }
    public void setCity(CityClass city) {
        this.city = city;
    }
    public int getId() {
        return id;
    }
    public String getBranch_name() {
        return branch_name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }
}
