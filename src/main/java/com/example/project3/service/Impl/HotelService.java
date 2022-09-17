package com.example.project3.service.Impl;

import com.example.project3.model.dto.Request.HotelRequest;
import com.example.project3.model.dto.Response.HotelResponse;

public interface HotelService {
    HotelResponse createHotel(HotelRequest hotelRequest);

    HotelResponse getHotelDetails(String external_id);
}
