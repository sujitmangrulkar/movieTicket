package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,String>
{
    public List<Ticket> findByUserUserId(String userId);

    public List<Ticket> findByMovieMovieId(String movieID);
    public List<Ticket> findByCinemaHallHallId(String cinemaHallId);

    public Ticket findByBookingBookingId(String bookingId);
}
