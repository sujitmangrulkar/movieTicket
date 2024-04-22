package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.CinemaHallDtoRequest;
import com.bookmyshow.api.payloads.response.CinemaHallDtoResponse;
import com.bookmyshow.api.service.CinemaHallService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cinemaHall")
public class CinemaHallController
{
    @Autowired
    private CinemaHallService cinemaHallService;

    @PostMapping("/addCinemaHall")
    public ResponseEntity<CinemaHallDtoResponse> addNewCinemaHall(@Valid @RequestBody CinemaHallDtoRequest cinemaHallDtoRequest)
    {
        CinemaHallDtoResponse cinemaHallDtoResponse = this.cinemaHallService.addNewCinemaHall(cinemaHallDtoRequest);

        return new ResponseEntity<>(cinemaHallDtoResponse,HttpStatus.CREATED);
    }

    @GetMapping("/getCinemaHallDetails")
    public ResponseEntity<List<CinemaHallDtoResponse>> getCinemaHallDetails()
    {
        List<CinemaHallDtoResponse> cinemaHallDetails = this.cinemaHallService.getCinemaHallDetails();

        return new ResponseEntity<>(cinemaHallDetails, HttpStatus.OK);

    }
 }
