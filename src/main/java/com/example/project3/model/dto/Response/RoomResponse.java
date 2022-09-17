package com.example.project3.model.dto.Response;


import com.example.project3.enums.RoomStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomResponse {

    private Long id;

    private String roomType;

    private Long roomNumber;

    private RoomStatus status;
}
