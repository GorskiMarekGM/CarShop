package com.example.carshop.models;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity
public class Car {
    private Integer id;
    private String name;
    private float price;
    private boolean is_available;

    @Autowired
    private Client client;

    public Car() {
    }

    public Car(Integer id, String name, float price, boolean is_available) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.is_available = is_available;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getIsAvailable() {
        return is_available;
    }

    public void setIsAvailable(boolean is_available) {
        this.is_available = is_available;
    }

    //Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean analyzeCarByParams(Integer id, String name, float price, boolean is_available, Client client){
        boolean idNull = null == id;
        boolean nameNull = null == name;

        if(idNull || nameNull || (price==0))
        {
            throw new IllegalArgumentException("Car details are not set properly");
        }

    return true;
    }
}
