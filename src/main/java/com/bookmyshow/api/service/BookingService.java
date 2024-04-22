package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.BookingDtoRequest;
import com.bookmyshow.api.payloads.response.BookingDtoResponse;

import java.util.List;

public interface BookingService
{
    BookingDtoResponse createBooking(String userId,String showTimeId, BookingDtoRequest bookingDtoRequest);

    List<BookingDtoResponse> getAllBookingDetails();

    List<BookingDtoResponse> getBookingsByUserId(String userId);
    List<BookingDtoResponse> getBookingsByMovieId(String movieId);
    List<BookingDtoResponse> getBookingsByCinemaHallId(String cinemaHallId);
}
