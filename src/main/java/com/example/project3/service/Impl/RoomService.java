package com.example.project3.service.Impl;

import com.example.project3.model.dto.Request.RoomRequest;
import com.example.project3.model.dto.Response.RoomResponse;

import java.util.List;

public interface RoomService {
    RoomResponse createRoom(RoomRequest roomRequest);

    List<RoomResponse>getAvailableRoomById(String externalId);

    Integer countTotalRoom(String hotelId);

    List<RoomResponse> getBookedRoom();


}
