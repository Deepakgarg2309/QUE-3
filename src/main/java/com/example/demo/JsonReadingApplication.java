
package com.example.demo;

import com.example.demo.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.DeserializationFeature;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class JsonReadingApplication {
        

	public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Person p = new Person();

        p.setAge(25);
        p.setName("Ankur");
        p.setSalary(1900.90);
        Person p1 = new Person();

        p1.setAge(30);
        p1.setName("Anuj");
        p1.setSalary(3999.90);

        List<Person> persons= new ArrayList<>();
        persons.add(p);
        persons.add(p1);
        String jsonString2 = objectMapper.writeValueAsString(persons);
        System.out.println(jsonString2);
        List<Person> person = objectMapper.readValue(jsonString2, new TypeReference<List<Person>>() {
        });
        System.out.println(person.get(0).getName());
        System.out.println(person.get(0).getAge());
        System.out.println(person.get(0).getSalary());
        System.out.println(person.get(1).getName());
        System.out.println(person.get(1).getAge());
        System.out.println(person.get(1).getSalary());

	}

}
