package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.ShowTimeDtoRequest;
import com.bookmyshow.api.payloads.response.ShowTimeDtoResponse;
import com.bookmyshow.api.service.ShowTimeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showTimeController")
public class ShowTimeController
{
    @Autowired
    private ShowTimeService showTimeService;
    @PostMapping("/{movieId}/{hallId}")
    public ResponseEntity<ShowTimeDtoResponse> addNewShowTime(@Valid @RequestBody ShowTimeDtoRequest showTimeDtoRequest, @PathVariable String movieId, @PathVariable String hallId)
    {
        ShowTimeDtoResponse showTimeDtoResponse = this.showTimeService.addNewShowTime(showTimeDtoRequest, movieId, hallId);

        return new ResponseEntity<>(showTimeDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/GetAllShowDetails")
    public ResponseEntity<List<ShowTimeDtoResponse>> getAllShowTimings()
    {
        List<ShowTimeDtoResponse> showTimeDetails = this.showTimeService.getShowTimeDetails();

        return new ResponseEntity<>(showTimeDetails,HttpStatus.OK);
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ShowTimeDtoResponse>> getShowTimeByMovieId(@PathVariable String movieId)
    {
        List<ShowTimeDtoResponse> showTimesByMovieId = this.showTimeService.getShowTimesByMovieId(movieId);

        return new ResponseEntity<>(showTimesByMovieId,HttpStatus.OK);
    }

    @GetMapping("/cinemaHall/{cinemaHallId}")
    public ResponseEntity<List<ShowTimeDtoResponse>> getShowTimesByCinemaHallId(@PathVariable String cinemaHallId)
    {
        List<ShowTimeDtoResponse> showTimesByCinemaHallId = this.showTimeService.getShowTimesByCinemaHallId(cinemaHallId);
        return new ResponseEntity<>(showTimesByCinemaHallId,HttpStatus.OK);
    }


}
