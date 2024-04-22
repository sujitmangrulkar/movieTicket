package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.TicketDtoRequest;
import com.bookmyshow.api.payloads.response.TicketDtoResponse;

import java.util.List;

public interface TicketService
{
    TicketDtoResponse generateTicket(String bookingId);

    List<TicketDtoResponse> getAllTickets();

   List<TicketDtoResponse> getTicketsByUserId(String userId);
   List<TicketDtoResponse> getTicketByMovieId(String movieId);
   List<TicketDtoResponse> getTicketsByCinemaHallId(String cinemaHallId);

    TicketDtoResponse getTicketByBookingId(String bookingId);

}
