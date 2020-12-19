//package com.example.carshop.models.mapper;
//
//
//import com.example.carshop.models.Car;
//import com.example.carshop.models.Client;
//import com.example.carshop.models.dto.CarDto;
//import com.example.carshop.models.dto.ClientDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring")
//public interface ClientMapper {
//
//    @Mappings({
//            @Mapping(target="client_id", source="client.id"),
//    })
//    ClientDto ClientToClientDto(Client entity);
//
//    @Mappings({
//            @Mapping(target="client.id", source="dto.client_id"),
//    })
//    Client ClientToClientDto(ClientDto dto);
//
//}