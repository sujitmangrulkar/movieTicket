package com.bookmyshow.api.payloads.response;

import com.bookmyshow.api.entity.Seat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CinemaHallDtoResponse
{
    private String hallId;

    private String hallName;

    private String location;

    private Integer seatingCapacity;

    private Integer screens;

}
