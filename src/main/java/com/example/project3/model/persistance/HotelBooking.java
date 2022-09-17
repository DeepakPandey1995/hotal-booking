package com.example.project3.model.persistance;

import com.example.project3.enums.HotelStatus;
import com.example.project3.enums.RoomStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;

    private String externalId;

    @Enumerated
    private HotelStatus status;

    private Timestamp bookedAt;

    private Timestamp bookedFor;

    private String hotelId;

    private Timestamp checkIn;

    private Timestamp checkOut;

}
