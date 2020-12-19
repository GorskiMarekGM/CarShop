package com.example.carshop.service;

import com.example.carshop.models.Car;
import com.example.carshop.models.Client;
import com.example.carshop.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository ClientRepo;

    public List<Client> listAll(){return ClientRepo.findAll();}

    public void save(Client client){ClientRepo.save(client);}

    public Client get(Integer id){return ClientRepo.findById(id).get();}

    public void delete(Integer id){ClientRepo.deleteById(id);}
}
