package com.example.carshop;

import com.example.carshop.models.Car;
import com.example.carshop.models.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    public void analyzeCarByParams_throwsIllegalArgumentException(){

        //given
        Integer id = 3;
        String name = "BMW";
        float price= 10000;
        boolean is_available = true;
        Client client = new Client();
        Car car = new Car();

        //then
        Assertions.assertThrows(IllegalArgumentException.class,() -> car.analyzeCarByParams(id,name, price, is_available, client));
    }
}
