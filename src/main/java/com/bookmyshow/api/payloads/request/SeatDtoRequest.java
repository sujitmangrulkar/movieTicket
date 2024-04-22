package com.bookmyshow.api.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDtoRequest
{
    private String seatName;
    private  Integer seatType;
}
