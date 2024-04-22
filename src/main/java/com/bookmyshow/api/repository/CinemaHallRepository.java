package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.CinemaHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CinemaHallRepository extends JpaRepository<CinemaHall, String>
{
}
