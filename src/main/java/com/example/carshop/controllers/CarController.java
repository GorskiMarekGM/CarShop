package com.example.carshop.controllers;

import com.example.carshop.models.Car;
import com.example.carshop.models.Client;
import com.example.carshop.models.dto.CarDto;
import com.example.carshop.models.mapper.CarMapper;
import com.example.carshop.service.CarService;
import com.example.carshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class CarController {

    @Autowired
    private CarService service;

    @Autowired
    private CarMapper mapper;
    //Create = POST
    //Read = GET
    //Update = PUT
    //Delete = DELETE

    //GET
    @GetMapping("/cars")
    public List<Car> list(){
        return service.listAll();
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> get(@PathVariable Integer id){
        try{
            Car car = service.get(id);
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/cars")
    public void add(@RequestBody CarDto car){
        service.save(mapper.CarToCarDto(car));
    }

    //PUT
    @PutMapping("/cars/{id}")
    public ResponseEntity<?> update(@RequestBody Car car, @PathVariable Integer id){
        try{
            Car existCar = service.get(id);
            service.save(car);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/cars/{id}")
    public void delete(@PathVariable Integer id){service.delete(id);}
}
