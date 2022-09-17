package com.example.project3.model.dto.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HotelResponse {
    private Long id;

    private String hotelName;

    private String hotelAddress;

    private String  hotelExternalId;

}
