package com.example.project3.controller;

import com.example.project3.model.dto.Request.CustomerRequest;
import com.example.project3.model.dto.Response.CustomerResponse;
import com.example.project3.service.Impl.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    public CustomerResponse createCustomer (@RequestBody CustomerRequest customerRequest){
        return customerService.createCustomer(customerRequest);
    }
}
