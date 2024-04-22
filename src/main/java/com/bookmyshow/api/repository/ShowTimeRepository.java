package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository<ShowTime,String>
{
    List<ShowTime> findByMovieMovieId(String movieId);

    List<ShowTime> findByCinemaHallHallId(String cinemaHallId);
}
