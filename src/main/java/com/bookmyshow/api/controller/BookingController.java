package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.BookingDtoRequest;
import com.bookmyshow.api.payloads.response.BookingDtoResponse;
import com.bookmyshow.api.service.BookingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController
{
    @Autowired
    private BookingService bookingService;

    @PostMapping("/{userId}/{showTimeId}")
    public ResponseEntity<BookingDtoResponse> createBooking(@PathVariable String userId, @PathVariable String showTimeId,@Valid  @RequestBody BookingDtoRequest bookingDtoRequest)
    {
        BookingDtoResponse booking = this.bookingService.createBooking(userId,showTimeId, bookingDtoRequest);

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
    @GetMapping("/getAllBookings")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingDetails()
    {
        List<BookingDtoResponse> allBookingDetails = this.bookingService.getAllBookingDetails();

        return new ResponseEntity<>(allBookingDetails,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingByUserId(@PathVariable String userId)
    {
        List<BookingDtoResponse> bookingsByUserId = this.bookingService.getBookingsByUserId(userId);

        return new ResponseEntity<>(bookingsByUserId,HttpStatus.OK);
    }

    @GetMapping("/movieId/{movieId}")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingsByMovieId(@PathVariable String movieId)
    {
        List<BookingDtoResponse> bookingsByMovieId = this.bookingService.getBookingsByMovieId(movieId);

        return new ResponseEntity<>(bookingsByMovieId,HttpStatus.OK);
    }

    @GetMapping("/cineHall/{cinemaHallId}")
    public ResponseEntity<List<BookingDtoResponse>> getAllBookingsByCinemaHallId(@PathVariable String cinemaHallId)
    {
        List<BookingDtoResponse> bookingsByCinemaHallId = this.bookingService.getBookingsByCinemaHallId(cinemaHallId);

        return new ResponseEntity<>(bookingsByCinemaHallId,HttpStatus.OK);
    }
}
