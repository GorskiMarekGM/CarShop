package com.example.carshop.service;

import com.example.carshop.models.Car;
import com.example.carshop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository CarRepo;

    public List<Car> listAll(){
        return CarRepo.findAll();
    }

    public void save(Car car){
        CarRepo.save(car);
    }

    public Car get(Integer id){
        return CarRepo.findById(id).get();
    }

    public Car find(Integer id) {
        return CarRepo.findById(id).orElse(null);
    }

    public void delete(Integer id){
        CarRepo.deleteById(id);
    }
}
