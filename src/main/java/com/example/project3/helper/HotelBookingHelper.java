package com.example.project3.helper;

import com.example.project3.enums.HotelStatus;
import com.example.project3.model.dto.Response.CustomerResponse;
import com.example.project3.model.dto.Response.HotelBookingResponse;
import com.example.project3.model.persistance.HotelBooking;

public class HotelBookingHelper {
    public static HotelBookingResponse populateHotelBookingResponse(HotelBooking hotelBooking){
        if (hotelBooking == null){
            return null;
        }
        return HotelBookingResponse.builder()
                .externalId(hotelBooking.getExternalId())
                .status(HotelStatus.Confirm)
                .bookedAt(hotelBooking.getBookedAt())
                .bookedFor(hotelBooking.getBookedFor())
                .hotelId(hotelBooking.getExternalId())
                .customerId(hotelBooking.getCustomerId())
                .build();
    }
}
