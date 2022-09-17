package com.example.project3.helper;

import com.example.project3.model.dto.Response.CustomerResponse;
import com.example.project3.model.persistance.Customer;

public class CustomerHelper {
    public static CustomerResponse populateCustomerResponse(Customer customer){
        if (customer == null) {
            return null;
        }
        return CustomerResponse.builder()
                .id(customer.getId())
                .name(customer.getName())
                .email(customer.getEmail())
                .mobile(customer.getMobile())
                .externalId(customer.getExternalId())
                .address(customer.getAddress())
                .build();
    }
}
