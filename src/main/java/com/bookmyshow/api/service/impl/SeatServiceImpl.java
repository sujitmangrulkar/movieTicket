package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Seat;
import com.bookmyshow.api.helper.SeatType;
import com.bookmyshow.api.payloads.request.SeatDtoRequest;
import com.bookmyshow.api.payloads.response.SeatDtoResponse;
import com.bookmyshow.api.repository.SeatRepository;
import com.bookmyshow.api.service.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService
{
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SeatDtoResponse createSeat(SeatDtoRequest seatDtoRequest)
    {
        Seat seat = new Seat();
        seat.setSeatName(seatDtoRequest.getSeatName());
        switch(seatDtoRequest.getSeatType())
        {
            case 1:
                seat.setSeatType(SeatType.PREMIUM);
                break;
            case 2:
                seat.setSeatType(SeatType.VIP);
                break;
            case 3:
                seat.setSeatType(SeatType.STANDARD);
                break;
        }

        Seat savedSeat = this.seatRepository.save(seat);

        return this.modelMapper.map(savedSeat,SeatDtoResponse.class);

    }

    @Override
    public List<SeatDtoResponse> showAllSeats()
    {
        List<Seat> allSeats = this.seatRepository.findAll();

        return allSeats.stream().map((seat)->modelMapper.map(seat,SeatDtoResponse.class)).collect(Collectors.toList());
    }

}
