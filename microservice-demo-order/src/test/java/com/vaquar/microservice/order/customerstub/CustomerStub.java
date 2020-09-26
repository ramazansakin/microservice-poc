package com.vaquar.microservice.order.customerstub;

import com.vaquar.microservice.order.clients.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/customer")
@Profile("test")
public class CustomerStub {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getById(@PathVariable("id") long id) {

        if (id != 42) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new Customer(42, "Eberhard",
                "Wolff", "eberhard.wolff@gmail.com", "Unter den Linden",
                "Berlin"), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public PagedResources<Customer> getAll() {
        return new PagedResources<>(Collections.singletonList(new Customer(42,
                "Eberhard", "Wolff", "eberhard.wolff@gmail.com",
                "Unter den Linden", "Berlin")), new PageMetadata(1, 0, 1));
    }

}
