package com.softwareengineering.rentacar.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "SaleTable")
@EntityListeners(AuditingEntityListener.class)
public class SaleClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;

    private Date from_date;

    private Date to_date;

    private Integer sold_cars_number;

    private Integer total_payment;

    private boolean paid;

    private boolean active;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerClass customer;

    @OneToOne
    @JoinColumn(name = "car_id")
    private CarClass car;
    //List CarClass

    public Integer getTotal_payment() {
        return total_payment;
    }
    public Date getTo_date() {
        return to_date;
    }

    public Date getFrom_date() {
        return from_date;
    }

    public Integer getId() {
        return id;
    }

    public CarClass getCar() {
        return car;
    }

    public Integer getSold_cars_number() {
        return sold_cars_number;
    }

    public CustomerClass getCustomer() {
        return customer;
    }

    public void setTo_date(Date to_date) {
        this.to_date = to_date;
    }

    public void setFrom_date(Date from_date) {
        this.from_date = from_date;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setCar(CarClass car) {
        this.car = car;
    }

    public void setCustomer(CustomerClass customer) {
        this.customer = customer;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setSold_cars_number(Integer sold_cars_number) {
        this.sold_cars_number = sold_cars_number;
    }

    public void setTotal_payment(Integer total_payment) {
        this.total_payment = total_payment;
    }
}