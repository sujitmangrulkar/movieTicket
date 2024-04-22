package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.SeatDtoRequest;
import com.bookmyshow.api.payloads.response.SeatDtoResponse;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatService
{
    SeatDtoResponse createSeat(SeatDtoRequest seatDtoRequest);
    List<SeatDtoResponse> showAllSeats();
}
