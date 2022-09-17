package com.example.project3.service.Impl;

import com.example.project3.dao.CustomerDao;
import com.example.project3.helper.CustomerHelper;
import com.example.project3.model.dto.Request.CustomerRequest;
import com.example.project3.model.dto.Response.CustomerResponse;
import com.example.project3.model.persistance.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component

public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerDao customerDao;

    @Override
    public CustomerResponse createCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .name(customerRequest.getName())
                .mobile(customerRequest.getMobile())
                .email(customerRequest.getEmail())
                .externalId(UUID.randomUUID().toString())
                .address(customerRequest.getAddress())
                .build();
        customerDao.persist(customer);
        return CustomerHelper.populateCustomerResponse(customer);
    }

}
