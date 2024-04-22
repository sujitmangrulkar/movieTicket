package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.ShowTimeDtoRequest;
import com.bookmyshow.api.payloads.response.ShowTimeDtoResponse;

import java.util.List;

public interface ShowTimeService
{
    ShowTimeDtoResponse addNewShowTime(ShowTimeDtoRequest showTimeDtoRequest, String movieId, String hallId);

    List<ShowTimeDtoResponse> getShowTimeDetails();

    List<ShowTimeDtoResponse> getShowTimesByMovieId(String movieId);

    List<ShowTimeDtoResponse> getShowTimesByCinemaHallId(String cinemaHallId);

}
