package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.SeatDtoRequest;
import com.bookmyshow.api.payloads.response.SeatDtoResponse;
import com.bookmyshow.api.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatsController
{
    @Autowired
    private SeatService seatService;

    @PostMapping("/addSeat")
    public ResponseEntity<SeatDtoResponse> addNewSeat(@RequestBody SeatDtoRequest seatDtoRequest)
    {
        SeatDtoResponse seat = this.seatService.createSeat(seatDtoRequest);

        return new ResponseEntity<>(seat, HttpStatus.CREATED);

    }

    @GetMapping("/getAllSeats")
    public ResponseEntity<List<SeatDtoResponse>> getAllSeats()
    {
        List<SeatDtoResponse> seatDtoResponses = this.seatService.showAllSeats();

        return new ResponseEntity<>(seatDtoResponses,HttpStatus.OK);
    }
}
