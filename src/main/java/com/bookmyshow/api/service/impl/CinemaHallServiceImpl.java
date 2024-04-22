package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.CinemaHall;
import com.bookmyshow.api.entity.Seat;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.CinemaHallDtoRequest;
import com.bookmyshow.api.payloads.response.CinemaHallDtoResponse;
import com.bookmyshow.api.repository.CinemaHallRepository;
import com.bookmyshow.api.repository.SeatRepository;
import com.bookmyshow.api.service.CinemaHallService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CinemaHallServiceImpl implements CinemaHallService
{
    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SeatRepository seatRepository;

    @Override
    public CinemaHallDtoResponse addNewCinemaHall(CinemaHallDtoRequest cinemaHallDtoRequest)
    {
        CinemaHall cinemaHall = this.modelMapper.map(cinemaHallDtoRequest, CinemaHall.class);

        List<Seat> seatsList=new ArrayList<>();
        for(String seatName: cinemaHallDtoRequest.getSeats())
        {
            Seat seat = this.seatRepository.findBySeatName(seatName).orElseThrow(() -> new ResourceNotFoundException("Seat", "SeatName", seatName));
            seatsList.add(seat);
        }
        cinemaHall.setSeats(seatsList);

        CinemaHall savedCinemaHall = this.cinemaHallRepository.save(cinemaHall);
        CinemaHallDtoResponse map = this.modelMapper.map(savedCinemaHall, CinemaHallDtoResponse.class);
        return map;
    }

    @Override
    public List<CinemaHallDtoResponse> getCinemaHallDetails()
    {
        List<CinemaHall> hallDetails = this.cinemaHallRepository.findAll();

        return hallDetails.stream().map((hall)->modelMapper.map(hall, CinemaHallDtoResponse.class)).collect(Collectors.toList());
    }


}
