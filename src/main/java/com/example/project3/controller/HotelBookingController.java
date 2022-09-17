package com.example.project3.controller;

import com.example.project3.model.dto.Request.HotelBookingRequest;
import com.example.project3.model.dto.Response.HotelBookingResponse;
import com.example.project3.service.Impl.HotelBookingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.ok;


@Slf4j
@RestController
@RequestMapping("/hotel-booking")
public class HotelBookingController {

    @Autowired
    private HotelBookingService hotelBookingService;

    @PostMapping
    public ResponseEntity<HotelBookingResponse> createHotelBooking (@RequestBody HotelBookingRequest hotelBookingRequest) {
        HotelBookingResponse hotelBookingResponse = hotelBookingService.createHotelBooking(hotelBookingRequest);
        return ResponseEntity.ok(hotelBookingResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<List<HotelBookingResponse>> getAllHotelBooking(@RequestParam ("hotelId") String hotelId){
         return ResponseEntity.ok(hotelBookingService.getAllHotelBooking(hotelId));
    }

    @PutMapping("/cancel-booking")
    public ResponseEntity cancelBooking (@RequestParam ("externalId") String externalId){
        hotelBookingService.cancelBooking(externalId);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
