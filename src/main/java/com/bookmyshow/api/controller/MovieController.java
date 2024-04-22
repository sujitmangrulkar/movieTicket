package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.MovieDtoRequest;
import com.bookmyshow.api.payloads.response.MovieDtoResponse;
import com.bookmyshow.api.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController
{
    @Autowired
    private MovieService movieService;


    @PostMapping("/addMovie")
    public ResponseEntity<MovieDtoResponse> addMovie(@Valid @RequestBody MovieDtoRequest movieDtoRequest)
    {
        MovieDtoResponse movieDtoResponse = this.movieService.addNewMovie(movieDtoRequest);
        return new ResponseEntity<>(movieDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getAllMovies")
    public ResponseEntity<List<MovieDtoResponse>> getAllMovis()
    {
        List<MovieDtoResponse> allMovies = this.movieService.getAllMovies();

        return new ResponseEntity<>(allMovies,HttpStatus.OK);
    }

    @GetMapping("/{searchTerm}")
    public ResponseEntity<List<MovieDtoResponse>> searchMovie(@PathVariable String searchTerm)
    {
        List<MovieDtoResponse> movieDtoRequests = this.movieService.searchMoviesByName(searchTerm);

        return new ResponseEntity<>(movieDtoRequests,HttpStatus.OK);
    }

}
