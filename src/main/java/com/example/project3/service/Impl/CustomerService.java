package com.example.project3.service.Impl;

import com.example.project3.model.dto.Request.CustomerRequest;
import com.example.project3.model.dto.Response.CustomerResponse;

public interface CustomerService {
    CustomerResponse createCustomer(CustomerRequest customerRequest);
}


