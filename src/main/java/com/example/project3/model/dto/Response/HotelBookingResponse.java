package com.example.project3.model.dto.Response;

import com.example.project3.enums.HotelStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.sql.Timestamp;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelBookingResponse {
    private Long Id;

    private String customerId;

    private Timestamp checkIn;

    private Timestamp checkOut;

    private String externalId;

    private HotelStatus status;

    private CustomerResponse customerResponse;

    private Timestamp bookedAt;

    private Timestamp bookedFor;

    private String hotelId;
}
