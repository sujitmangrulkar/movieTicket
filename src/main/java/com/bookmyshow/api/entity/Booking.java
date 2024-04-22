package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name="BOOKING_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Booking
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bookingId;

//    @Column(name="USER_ID")
//    private String userId;

//    @Column(name="MOVIE_ID")
//    private String movieId;

//    @Column(name="HALL_ID")
//    private String hallId;

//    @Column(name="SHOW_TIME_ID")
//    private String showTimeId;

    @Column(name="BOOKED_SEATS")
    private List<String> seats;

    @Column(name="TICKET_CHARGES")
    private Double totalTicketCharges;

    @Column(name="FOOD_CHARGES")
    private Double totalFoodCharges;

    @Column(name="TOTAL_AMOUNT")
    private Double totalAmount;

    @Column(name="BOOKING_STATUS")
    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private CinemaHall cinemaHall;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Payment payment;

    @OneToOne(mappedBy = "booking",cascade = CascadeType.ALL)
    private Ticket ticket;

    @ManyToOne
    private ShowTime showTime;

    @OneToMany(mappedBy = "booking")
    private List<Seat> bookedSeats;

}
