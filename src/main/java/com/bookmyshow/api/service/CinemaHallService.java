package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.CinemaHallDtoRequest;
import com.bookmyshow.api.payloads.response.CinemaHallDtoResponse;

import java.util.List;

public interface CinemaHallService
{
   CinemaHallDtoResponse addNewCinemaHall(CinemaHallDtoRequest cinemaHallDtoRequest);
   List<CinemaHallDtoResponse> getCinemaHallDetails();
}
