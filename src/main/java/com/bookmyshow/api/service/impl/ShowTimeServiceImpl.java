package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.CinemaHall;
import com.bookmyshow.api.entity.Movie;
import com.bookmyshow.api.entity.ShowTime;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.ShowTimeDtoRequest;
import com.bookmyshow.api.payloads.response.ShowTimeDtoResponse;
import com.bookmyshow.api.repository.CinemaHallRepository;
import com.bookmyshow.api.repository.MovieRepository;
import com.bookmyshow.api.repository.ShowTimeRepository;
import com.bookmyshow.api.service.ShowTimeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowTimeServiceImpl implements ShowTimeService
{
    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Override
    public ShowTimeDtoResponse addNewShowTime(ShowTimeDtoRequest showTimeDtoRequest, String movieId, String hallId)
    {
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie", "MovieId", movieId));
        CinemaHall cinemaHall = this.cinemaHallRepository.findById(hallId).orElseThrow(() -> new ResourceNotFoundException("CinemaHall", "HallId", hallId));

        ShowTime show = this.modelMapper.map(showTimeDtoRequest, ShowTime.class);

        show.setMovie(movie);
        show.setCinemaHall(cinemaHall);

        ShowTime savedShow = this.showTimeRepository.save(show);

        return this.modelMapper.map(savedShow, ShowTimeDtoResponse.class);
    }

    @Override
    public List<ShowTimeDtoResponse> getShowTimeDetails()
    {
        List<ShowTime> allShowTimes = this.showTimeRepository.findAll();
        List<ShowTimeDtoResponse> collect = allShowTimes.stream().map((show) -> modelMapper.map(show, ShowTimeDtoResponse.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ShowTimeDtoResponse> getShowTimesByMovieId(String movieId)
    {
        List<ShowTime> showTimesByMovieId = this.showTimeRepository.findByMovieMovieId(movieId);
        return showTimesByMovieId.stream().map((showTime)->modelMapper.map(showTime, ShowTimeDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<ShowTimeDtoResponse> getShowTimesByCinemaHallId(String cinemaHallId)
    {
        List<ShowTime> byCinemaHallHallId = this.showTimeRepository.findByCinemaHallHallId(cinemaHallId);

        return byCinemaHallHallId.stream().map((showTime)->modelMapper.map(showTime, ShowTimeDtoResponse.class)).collect(Collectors.toList());
    }
}
