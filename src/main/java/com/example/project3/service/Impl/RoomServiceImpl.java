package com.example.project3.service.Impl;

import com.example.project3.dao.RoomDao;
import com.example.project3.enums.RoomStatus;
import com.example.project3.helper.RoomHelper;
import com.example.project3.model.dto.Request.RoomRequest;
import com.example.project3.model.dto.Response.HotelBookingResponse;
import com.example.project3.model.dto.Response.HotelResponse;
import com.example.project3.model.dto.Response.RoomResponse;
import com.example.project3.model.persistance.Hotel;
import com.example.project3.model.persistance.HotelBooking;
import com.example.project3.model.persistance.Room;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.example.project3.helper.HotelBookingHelper.populateHotelBookingResponse;
import static com.example.project3.helper.RoomHelper.populateRoomResponse;

@Component
@Transactional
@Slf4j
public class RoomServiceImpl implements RoomService{

    @Autowired
    private RoomDao roomDao;

    @Autowired
    private HotelService hotelService;

    @Override
    public RoomResponse createRoom(RoomRequest roomRequest) {
        Room room = Room.builder()
                .roomNumber(roomRequest.getRoomNumber())
                .roomType(roomRequest.getRoomType())
                .id(roomRequest.getId())
                .status(RoomStatus.Available)
                .build();
        roomDao.persist(room);
        return populateRoomResponse(room);
    }

    @Override
    public List<RoomResponse> getAvailableRoomById(String externalId) {
        HotelResponse hotelResponse =hotelService.getHotelDetails(externalId);
        long hotelId = hotelResponse.getId();
         List<Room> rooms = roomDao.getAvailableRoom(hotelId);
        List<RoomResponse>roomResponses = new ArrayList<>();
        for (Room room : rooms){
            roomResponses.add(populateRoomResponse(room));
        }
        return roomResponses;
    }

    @Override
    public Integer countTotalRoom(String externalId) {
        HotelResponse hotelResponse = hotelService.getHotelDetails(externalId);
        long hotelId = hotelResponse.getId();
        return roomDao.countTotalRoom(hotelId);
    }

    @Override
    public List<RoomResponse> getBookedRoom() {
        List<Room> rooms = roomDao.getBookedRoom();
        List<RoomResponse>roomResponses = new ArrayList<>();
        for (Room room : rooms){
            roomResponses.add(populateRoomResponse(room));
        }
        return roomResponses;
    }

}


