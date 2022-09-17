package com.example.project3.service.Impl;

import com.example.project3.dao.HotelDao;
import com.example.project3.helper.HotelHelper;
import com.example.project3.model.dto.Request.HotelRequest;
import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.persistance.Hotel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
@Component
@Transactional
@Slf4j
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelDao hotelDao;

    @Override
    public HotelResponse createHotel(HotelRequest hotelRequest) {
        Hotel hotel = Hotel.builder()
                .hotelName(hotelRequest.getHotelName())
                .hotelAddress(hotelRequest.getHotelAddress())
                .hotelExternalId(UUID.randomUUID().toString())
                .build();
        hotelDao.persist(hotel);
        return HotelHelper.populateHotelResponse(hotel);
    }

    @Override
    public HotelResponse getHotelDetails(String external_id) {
        return HotelHelper.populateHotelResponse(hotelDao.getHoteldetail(external_id));
    }
}
