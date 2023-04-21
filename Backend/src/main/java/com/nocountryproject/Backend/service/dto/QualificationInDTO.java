package com.nocountryproject.Backend.service.dto;

import io.swagger.v3.oas.annotations.servers.Server;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QualificationInDTO {
    private Long idUser;
    private Long idBook;
    private int score;
    private String review;

}
