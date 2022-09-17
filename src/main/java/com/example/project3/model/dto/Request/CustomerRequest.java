package com.example.project3.model.dto.Request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerRequest {
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String externalId;

    private String address;
}
