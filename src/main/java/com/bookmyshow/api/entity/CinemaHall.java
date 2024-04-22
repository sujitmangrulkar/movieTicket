package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="CINEMA_HALL")
public class CinemaHall
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String hallId;

    @Column(name="HALL_NAME")
    private String hallName;

    @Column(name="LOCATION")
    private String location;

    @Column(name="SEATING_CAPACITY")
    private Integer seatingCapacity;

    @Column(name="SCREENS")
    private Integer screens;

    @OneToMany(mappedBy = "cinemaHall",cascade = CascadeType.ALL)
    private List<Booking> bookings= new ArrayList<>();

    @OneToMany(mappedBy = "cinemaHall",cascade = CascadeType.ALL)
    private List<ShowTime> showTime=new ArrayList<>();

    @OneToMany(mappedBy = "cinemaHall",cascade = CascadeType.ALL)
    private List<Ticket> tickets=new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "cinema_hall_seat",
            joinColumns = @JoinColumn(name = "cinema_hall_id"),
            inverseJoinColumns = @JoinColumn(name = "seat_id")
    )
    private List<Seat> seats;


}
