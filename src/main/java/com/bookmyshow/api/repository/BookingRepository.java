package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,String>
{
    public List<Booking> findByUserUserId(String userId);

    public List<Booking> findByMovieMovieId(String movieId);

    public List<Booking> findByCinemaHallHallId(String cinemaHallId);

}
