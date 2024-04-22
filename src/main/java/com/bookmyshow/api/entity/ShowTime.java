package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="SHOW_TIME")
public class ShowTime
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String showTimeId;

//    @Column(name="MOVIE_ID")
//    private String movieId;
//
//    @Column(name="HALL_ID")
//    private String hallId;

    @Column(name="TICKET_PRICES")
    private Double[] ticketPrice;

    @Column(name="START_TIME")
    private LocalDateTime startTime;

    @Column(name="END_TIME")
    private LocalDateTime endTime;

    @Column(name="AVAILABLE_SEATS")
    private Integer availableSeats;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToMany(mappedBy = "showTime",cascade = CascadeType.ALL)
    private List<Booking> bookings;





}
