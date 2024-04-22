package com.bookmyshow.api.payloads.request;

import com.bookmyshow.api.entity.Seat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CinemaHallDtoRequest
{

    //@NotEmpty
    private String hallName;

    //@NotEmpty
    private String location;

    //@NotEmpty
    private Integer seatingCapacity;

    //@NotEmpty
    private Integer screens;

    private List<String> seats;


}
