package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,String>
{
    public Optional<Seat> findBySeatName(String seatName);

}
