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
public class CustomerResponse {
    private Long id;

    private String name;

    private String email;

    private String mobile;

    private String externalId;

    private String address;
}
