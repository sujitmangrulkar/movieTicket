package com.bookmyshow.api.payloads.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowTimeDtoRequest
{
  //  private String showTimeId;

 //    private String movieId;
 //
 //    private String hallId;

    private Double[] ticketPrice;

    //@NotEmpty
    private LocalDateTime startTime;

    //@NotEmpty
    private LocalDateTime endTime;

    //@NotEmpty
    private Integer availableSeats;

}
