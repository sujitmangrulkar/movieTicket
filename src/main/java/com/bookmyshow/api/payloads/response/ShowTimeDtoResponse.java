package com.bookmyshow.api.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowTimeDtoResponse
{
    private String showTimeId;

    private String movieId;

    private String hallId;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Double[] ticketPrice;

    private Integer availableSeats;

}
