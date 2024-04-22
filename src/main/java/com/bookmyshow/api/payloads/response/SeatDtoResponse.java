package com.bookmyshow.api.payloads.response;

import com.bookmyshow.api.helper.SeatType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatDtoResponse
{
    private String seatId;
    private String seatName;
    private SeatType seatType;
}
