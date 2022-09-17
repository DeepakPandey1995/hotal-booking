package com.example.project3.controller;

import com.example.project3.model.dto.Request.HotelRequest;
import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.service.Impl.HotelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public HotelResponse createHotel (@RequestBody HotelRequest hotelRequest){
        return hotelService.createHotel(hotelRequest);
    }
}
