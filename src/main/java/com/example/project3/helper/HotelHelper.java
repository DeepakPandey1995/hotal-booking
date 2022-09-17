package com.example.project3.helper;

import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.persistance.Hotel;

public class HotelHelper {
    public static HotelResponse populateHotelResponse(Hotel hotel){
        if (hotel == null) {
            return null;
        }
        return HotelResponse.builder()
                .id(hotel.getId())
                .hotelName(hotel.getHotelName())
                .hotelAddress(hotel.getHotelAddress())
                .hotelExternalId(hotel.getHotelExternalId())
                .build();
    }
}
