package com.example.carshop;

import com.example.carshop.models.Car;
import com.example.carshop.models.Client;
import com.example.carshop.repository.CarRepository;
import com.example.carshop.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService service;
    @MockBean
    private CarRepository repository;

    Client testClient = new Client();

    @Test
    void listAll_whenFound_thenReturnResult() {

        Car car1 = new Car(
                1,
                "car",
                234,
                true
        );
        Car car2 = new Car(
                2,
                "car2",
                234,
                true
        );

        doReturn(
                Arrays.asList(car1, car2)
        )
                .when(
                        repository
                )
                .findAll();
        // Execute the service call
        Iterable<Car> cars = service.listAll();
        // Assert the response
        Assertions.assertEquals(
                2,
                StreamSupport.stream(cars.spliterator(), false).count()
        );
    }
    @Test
    void find_whenFound_thenReturnResult() {

        Car car = new Car(
                1,
                "car",
                234,
                true
        );
        doReturn(Optional.of(car)).when(repository).findById(1);
        // Execute the service call
        Car result = service.find(1);
        // Assert the response
        Assertions.assertTrue((result != null) );
        Assertions.assertSame(result, car);
    }
    @Test
    void find_whenNotFound_thenReturnNull() {
        // Setup our mock repository
        doReturn(Optional.empty()).when(repository).findById(1);
        // Execute the service call
        Car result = service.find(1);
        // Assert the response
        Assertions.assertTrue((result == null));
    }

}
