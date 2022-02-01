package com.altsystem.customerregistration.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altsystem.customerregistration.entities.Customers;
import com.altsystem.customerregistration.repositories.CustomersRepository;

@RestController
@RequestMapping("/api/customer")
public class CustomersController {

	@Autowired
    private CustomersRepository customersRepository;
        
    @GetMapping
    public List<Customers> findAllUCustomers(){
    	return (List<Customers>) customersRepository.findAll();
    }
        
    @GetMapping("/{id}")
    public ResponseEntity<Customers> findUserById(@PathVariable(value = "id") long id) {
    	Optional<Customers> user = customersRepository.findById(id);
    	 
        if(user.isPresent()) {
            return ResponseEntity.ok().body(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    
    }
 
    
    @PostMapping
    public Customers saveCustomer(@Validated @RequestBody Customers customer) {
        return customersRepository.save(customer);
    }
  
    

}
