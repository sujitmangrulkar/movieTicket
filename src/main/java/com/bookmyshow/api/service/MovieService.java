package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.MovieDtoRequest;
import com.bookmyshow.api.payloads.response.MovieDtoResponse;

import java.util.List;

public interface MovieService
{
    MovieDtoResponse addNewMovie(MovieDtoRequest movieDtoRequest);
    List<MovieDtoResponse> getAllMovies();

    List<MovieDtoResponse> searchMoviesByName(String searchTerm);
}
