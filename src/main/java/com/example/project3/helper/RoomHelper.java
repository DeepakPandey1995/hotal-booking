package com.example.project3.helper;

import com.example.project3.enums.RoomStatus;
import com.example.project3.model.dto.Response.RoomResponse;
import com.example.project3.model.persistance.Room;

public class RoomHelper {
    public static RoomResponse populateRoomResponse (Room room){
        if (room == null) {
            return null;
        }
        return RoomResponse.builder()
                .id(room.getId())
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .status(room.getStatus())
                .build();
    }
}
