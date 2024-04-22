package com.bookmyshow.api.entity;

import com.bookmyshow.api.helper.SeatType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SEAT_DTLS")
@ToString
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String seatId;

    @Column(name="SEAT_NAME")
    private String seatName;

    @Column(name="SEAT_TYPE")
    private SeatType seatType;

    @ManyToOne
    private Booking booking;

    @ManyToMany(mappedBy = "seats",cascade=CascadeType.ALL)
    private List<CinemaHall> cinemaHalls;

}
