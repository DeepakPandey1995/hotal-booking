package com.example.project3.service.Impl;

import com.example.project3.dao.HotelBookingDao;
import com.example.project3.enums.HotelStatus;
import com.example.project3.enums.RoomStatus;
import com.example.project3.model.dto.Request.CustomerRequest;
import com.example.project3.model.dto.Request.HotelBookingRequest;
import com.example.project3.model.dto.Request.HotelRequest;
import com.example.project3.model.dto.Response.CustomerResponse;
import com.example.project3.model.dto.Response.HotelBookingResponse;
import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.persistance.HotelBooking;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.example.project3.helper.HotelBookingHelper.populateHotelBookingResponse;
@Component
@Transactional
@Slf4j
public class HotelBookingServiceImpl implements HotelBookingService {

    @Autowired
    private HotelBookingDao hotelBookingDao;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RoomService roomService;


    @Override
    public HotelBookingResponse createHotelBooking(HotelBookingRequest hotelBookingRequest) {
        if (roomService.countTotalRoom(hotelBookingRequest.getHotelId()) > hotelBookingDao.countTotalBookingRequest(hotelBookingRequest.getHotelId())) {
            HotelBooking hotel = HotelBooking.builder()
                    .bookedAt(new Timestamp(System.currentTimeMillis()))
                    .bookedFor(hotelBookingRequest.getBookedFor())
                    .externalId(UUID.randomUUID().toString())
                    .status(HotelStatus.Confirm)
                    .customerId(getCustomerId(hotelBookingRequest))
                    .hotelId(hotelBookingRequest.getHotelId())
                    .customerId(hotelBookingRequest.getHotelId())
                    .build();

            hotelBookingDao.persist(hotel);
            return populateHotelBookingResponse(hotel);
        }
        throw new RuntimeException("Hotel is unavailable");
    }

    private String getCustomerId(HotelBookingRequest hotelBookingRequest) {
        CustomerRequest customerRequest = hotelBookingRequest.getCustomerDetails();
        CustomerResponse customerResponse = customerService.createCustomer(customerRequest);
        return customerResponse.getExternalId();
    }

    @Override
    public List<HotelBookingResponse> getAllHotelBooking(String hotelId) {
        List<HotelBooking> hotelBookings = hotelBookingDao.getAllHotelBooking(hotelId);
        List<HotelBookingResponse> hotelBookingResponses = new ArrayList<>();
        for (HotelBooking hotelBooking : hotelBookings) {
            hotelBookingResponses.add(populateHotelBookingResponse(hotelBooking));
        }
        return hotelBookingResponses;
    }

    @Override
    public void cancelBooking(String externalId) {
        HotelBooking hotelBooking = hotelBookingDao.getHotelBooking(externalId);
        hotelBooking.setStatus(HotelStatus.CANCEL);
        hotelBookingDao.update(hotelBooking);
    }
}
