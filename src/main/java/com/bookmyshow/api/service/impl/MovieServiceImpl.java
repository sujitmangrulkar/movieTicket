package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Movie;
import com.bookmyshow.api.payloads.request.MovieDtoRequest;
import com.bookmyshow.api.payloads.response.MovieDtoResponse;
import com.bookmyshow.api.repository.MovieRepository;
import com.bookmyshow.api.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService
{
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MovieDtoResponse addNewMovie(MovieDtoRequest movieDtoRequest)
    {
        Movie movie = this.modelMapper.map(movieDtoRequest, Movie.class);
        Movie savedMovie = this.movieRepository.save(movie);

        return this.modelMapper.map(savedMovie, MovieDtoResponse.class);
    }

    @Override
    public List<MovieDtoResponse> getAllMovies()
    {
        List<Movie> all = this.movieRepository.findAll();
        List<MovieDtoResponse> movieDtoRequestList = all.stream().map((movie) -> modelMapper.map(movie, MovieDtoResponse.class)).collect(Collectors.toList());
        return movieDtoRequestList;
    }

    @Override
    public List<MovieDtoResponse> searchMoviesByName(String searchTerm)
    {
        List<Movie> allMovies = movieRepository.findAll();
        List<MovieDtoResponse> resultMovies = new ArrayList<>();

        for(Movie movie:allMovies)
        {
            if(movie.getMovieTitle().toLowerCase().contains(searchTerm.toLowerCase()))
            {
                resultMovies.add(modelMapper.map(movie, MovieDtoResponse.class));
            }
        }

        return resultMovies;
    }
}
