package com.example.securitybasic.controller;

import com.example.securitybasic.model.Customer;
import com.example.securitybasic.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    CustomerRepository customerRepository;

    public LoginController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Customer customer){
        Customer savedCustomer;
        ResponseEntity response = null;
        try{
            savedCustomer = customerRepository.save(customer);
            if(savedCustomer.getId()>0){
                response = ResponseEntity.status(HttpStatus.CREATED)
                        .body("Create user successfully!");
            }

        }catch (Exception e){
            response = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An Exception has occurred due to " + e.getMessage());
        }
        return response;
    }
}
