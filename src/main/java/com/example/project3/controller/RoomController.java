package com.example.project3.controller;

import com.example.project3.model.dto.Request.RoomRequest;
import com.example.project3.model.dto.Response.RoomResponse;
import com.example.project3.service.Impl.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/room")
public class RoomController {


    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<RoomResponse> createRoom (@RequestBody RoomRequest roomRequest){
        RoomResponse roomResponse =roomService.createRoom(roomRequest);
        return ResponseEntity.ok(roomResponse);
    }

    @GetMapping("/all-booked")
    public ResponseEntity<List<RoomResponse>> getBookedRoom(){
        return ResponseEntity.ok(roomService.getBookedRoom());
    }

    @GetMapping("/all-free")
    public ResponseEntity<List<RoomResponse>> getAvailableRoomById(@RequestParam ("externalId") String externalId ){
        return ResponseEntity.ok(roomService.getAvailableRoomById(externalId));
    }

}
