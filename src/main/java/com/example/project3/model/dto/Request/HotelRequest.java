package com.example.project3.model.dto.Request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelRequest {
    private Long id;

    private String hotelName;

    private String hotelAddress;

    private String  hotelExternalId;
}
