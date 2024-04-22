package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="TICKET_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Ticket
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String ticketId;

//    @Column(name="BOOKING_ID")
//    private String booking_id;

    @Column(name="SEAT_NUMBERS")
    private List<String> seatNumbers;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToOne
    private Booking booking;

    @OneToOne
    private Payment payment;


}
