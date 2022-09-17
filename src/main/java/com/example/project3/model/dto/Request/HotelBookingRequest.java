package com.example.project3.model.dto.Request;

import com.example.project3.enums.HotelStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelBookingRequest {
    private Timestamp checkIn;

    private Timestamp checkOut;

    private String externalId;

    private HotelStatus status;

    private CustomerRequest customerDetails;

    private Timestamp bookedAt;

    private Timestamp bookedFor;

    private String hotelId;
}
