package com.softwareengineering.rentacar.model;

import javax.persistence.*;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "CarTable")
@EntityListeners(AuditingEntityListener.class)
public class CarClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
    private String car_brand;
    private String car_model;
    private double car_daily_price;
    private boolean is_car_available;//tamirde vs. ise 0.
    private String car_geartype;
    private String car_fueltype;
    private String car_price_class;
    private boolean car_has_ac;
    private Integer available_car_number;
    private Integer car_numberof_doors;
    private Integer car_numberof_seats;
    private String car_image;
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchClass branch;
    public CarClass(){ }

    public CarClass(Integer id, BranchClass branch){
        this.branch = branch;
        this.id = id;
    }
    public CarClass(Integer id, String car_brand, String car_model){
        this.id = id;
        this.car_model = car_model;
        this.car_brand = car_brand;
    }
    /*public CarClass(String car_brand, String car_model,double car_daily_price, boolean is_car_available, String car_geartype, String car_fueltype, String car_price_class, boolean car_has_ac, Integer available_car_number, Integer car_numberof_doors, Integer car_numberof_seats, String car_image,BranchClass branch){
        this.car_brand = car_brand; this.car_model = car_model; this.car_daily_price = car_daily_price;
        this.is_car_available = is_car_available; this.car_geartype = car_geartype; this.car_fueltype = car_fueltype;
        this.car_price_class = car_price_class; this.car_has_ac = car_has_ac; this.available_car_number = available_car_number;
        this.car_numberof_doors = car_numberof_doors; this.car_numberof_seats = car_numberof_seats; this.car_image = car_image;
        this.branch = branch;
    }*/
    public Integer getId() {
        return id;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public String getCar_model() {
        return car_model;
    }

    public double getCar_daily_price() {
        return car_daily_price;
    }

    public boolean isIs_car_available() {
        return is_car_available;
    }

    public String getCar_geartype() {
        return car_geartype;
    }

    public String getCar_fueltype() {
        return car_fueltype;
    }

    public String getCar_price_class() {
        return car_price_class;
    }

    public boolean isCar_has_ac() {
        return car_has_ac;
    }

    public Integer getAvailable_car_number() {
        return available_car_number;
    }

    public Integer getCar_numberof_doors() {
        return car_numberof_doors;
    }

    public Integer getCar_numberof_seats() {
        return car_numberof_seats;
    }

    public String getCar_image() {
        return car_image;
    }

    public BranchClass getBranch() {
        return branch;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public void setCar_daily_price(double car_daily_price) {
        this.car_daily_price = car_daily_price;
    }

    public void setIs_car_available(boolean is_car_available) {
        this.is_car_available = is_car_available;
    }

    public void setCar_geartype(String car_geartype) {
        this.car_geartype = car_geartype;
    }

    public void setCar_fueltype(String car_fueltype) {
        this.car_fueltype = car_fueltype;
    }

    public void setCar_price_class(String car_price_class) {
        this.car_price_class = car_price_class;
    }

    public void setCar_has_ac(boolean car_has_ac) {
        this.car_has_ac = car_has_ac;
    }

    public void setAvailable_car_number(Integer available_car_number) {
        this.available_car_number = available_car_number;
    }

    public void setCar_numberof_doors(Integer car_numberof_doors) {
        this.car_numberof_doors = car_numberof_doors;
    }

    public void setCar_numberof_seats(Integer car_numberof_seats) {
        this.car_numberof_seats = car_numberof_seats;
    }

    public void setCar_image(String car_image) {
        this.car_image = car_image;
    }

    public void setBranch(BranchClass branch) {
        this.branch = branch;
    }
}