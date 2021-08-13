package com.vwardi.restapitemplate.contract.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class CreateNewBasicRequestTest {


    private ObjectMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    void shouldCreateObject_whenJsonIsValid() throws JsonProcessingException {
        // {"name":"victor", "age":"36"}
        String jsonInput = "{\"name\":\"victor\", \"age\":\"36\"}";

        CreateNewBasicRequest actualObject = mapper.readValue(jsonInput, CreateNewBasicRequest.class);

       CreateNewBasicRequest expectedCreatedObject = new CreateNewBasicRequest("victor", 36);

        System.out.println(mapper.writeValueAsString(expectedCreatedObject));

        assertEquals(expectedCreatedObject, actualObject);
    }

}