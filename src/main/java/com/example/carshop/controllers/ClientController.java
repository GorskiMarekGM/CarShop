package com.example.carshop.controllers;

import com.example.carshop.models.Client;
import com.example.carshop.models.dto.ClientDto;
import com.example.carshop.models.mapper.CarMapper;
import com.example.carshop.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @Autowired
    private CarMapper mapper;

    //Create = POST
    //Read = GET
    //Update = PUT
    //Delete = DELETE

    //GET
    @GetMapping("/clients")
    public List<Client> list(){return service.listAll();}

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> get(@PathVariable Integer id){
        try{
            Client client = service.get(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

    //POST
    @PostMapping("/clients")
    public void add(@RequestBody Client client){
        service.save(client);
    }

    //PUT
    @PutMapping("/clients/{id}")
    public ResponseEntity<?> update(@RequestBody Client client, @PathVariable Integer id){
        try{
            Client existCar = service.get(id);
            service.save(client);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/clients/{id}")
    public void delete(@PathVariable Integer id){service.delete(id);}
}
