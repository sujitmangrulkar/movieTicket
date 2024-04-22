package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.TicketDtoRequest;
import com.bookmyshow.api.payloads.response.TicketDtoResponse;
import com.bookmyshow.api.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController
{
    @Autowired
    private TicketService ticketService;
    @PostMapping("/{paymentId}")
    public ResponseEntity<TicketDtoResponse> generateTicket(@PathVariable String paymentId)
    {
        TicketDtoResponse ticketDtoResponse = this.ticketService.generateTicket(paymentId);
        return new ResponseEntity<>(ticketDtoResponse, HttpStatus.CREATED);

    }

    @GetMapping("/getAllTickets")
    public ResponseEntity<List<TicketDtoResponse>> getAllTicekts()
    {
        List<TicketDtoResponse> allTickets = this.ticketService.getAllTickets();

        return new ResponseEntity<>(allTickets,HttpStatus.OK);

    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TicketDtoResponse>> getTicketsByUserId(@PathVariable String userId)
    {
        List<TicketDtoResponse> ticketsByUserId = this.ticketService.getTicketsByUserId(userId);

        return new ResponseEntity<>(ticketsByUserId,HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<TicketDtoResponse>> getTicketsByMovieId(@PathVariable String movieId)
    {
        List<TicketDtoResponse> ticketByMovieId = this.ticketService.getTicketByMovieId(movieId);

        return new ResponseEntity<>(ticketByMovieId,HttpStatus.OK);
    }

    @GetMapping("/cinemaHall/{cinemaHallId}")
    public ResponseEntity<List<TicketDtoResponse>> getTicketsByCinemaHallId(@PathVariable String cinemaHallId)
    {
        List<TicketDtoResponse> ticketsByCinemaHallId = this.ticketService.getTicketsByCinemaHallId(cinemaHallId);
        return new ResponseEntity<>(ticketsByCinemaHallId,HttpStatus.OK);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<TicketDtoResponse> getTicketsByBookingId(@PathVariable String bookingId)
    {
        TicketDtoResponse ticketByBookingId = this.ticketService.getTicketByBookingId(bookingId);
        return new ResponseEntity<>(ticketByBookingId,HttpStatus.OK);
    }
}
