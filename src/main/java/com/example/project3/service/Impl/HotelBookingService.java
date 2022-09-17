package com.example.project3.service.Impl;

import com.example.project3.model.dto.Request.HotelBookingRequest;
import com.example.project3.model.dto.Response.HotelBookingResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface HotelBookingService {

    HotelBookingResponse createHotelBooking(HotelBookingRequest hotelBookingRequest);

    List<HotelBookingResponse> getAllHotelBooking(String hotelId);

    void cancelBooking(String externalId);
}
