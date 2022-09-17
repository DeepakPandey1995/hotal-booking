package com.example.project3.model.persistance;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hotelName;

    private String hotelAddress;

    private String  hotelExternalId;

    @OneToMany
    @JoinColumn(name = "hotel_id")
    private List<Room> rooms;
}
