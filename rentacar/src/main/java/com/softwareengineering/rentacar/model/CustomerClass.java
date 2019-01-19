package com.softwareengineering.rentacar.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "CustomerTable")
@EntityListeners(AuditingEntityListener.class)
public class CustomerClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private String name;
    private String surname;
    //private Date birthday;
    private String email;
    private Integer tc_number;
    private String address;
    private String delivery_address;
    //private Integer numberof_rented_cars;
    private String company_name;
    //private Date from_date;
    //private Date to_date;
    //private Integer rented_cars;
    /*@OneToOne
    @JoinColumn(name = "car_id")
    private CarClass car;*/
    //araba ve aldığı tarihleri ekle, sale i sil.


    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTc_number() {
        return tc_number;
    }

    public void setTc_number(Integer tc_number) {
        this.tc_number = tc_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

}
