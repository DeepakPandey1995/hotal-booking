package com.example.project3.model.dto.Request;


import com.example.project3.enums.RoomStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomRequest {
    private Long id;

    private String roomType;

    private Long roomNumber;

    private RoomStatus status;
}
