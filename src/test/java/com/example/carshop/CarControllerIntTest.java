package com.example.carshop;

import com.example.carshop.controllers.CarController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
public class CarControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void Car() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/cars/9");
        MvcResult result = mvc.perform(request).andReturn();

        assertEquals("9, Mercedes, 450000.0, 0, 6", result.getResponse().getContentAsString());
    }
}
