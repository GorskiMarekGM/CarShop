package com.example.carshop.models.mapper;

import com.example.carshop.models.Car;
import com.example.carshop.models.dto.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {

        @Mappings({
                @Mapping(target="client_id", source="client.id"),
        })
        CarDto CarToCarDto(Car entity);

        @Mappings({
                @Mapping(target="client.id", source="dto.client_id"),
        })
        Car CarToCarDto(CarDto dto);

        List<CarDto> map(Iterable<Car> cars);

}
