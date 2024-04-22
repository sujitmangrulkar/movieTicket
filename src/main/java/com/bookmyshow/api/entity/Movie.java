package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="MOVIE_DTLS")
public class Movie
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String movieId;

    @Column(name="MOVIE_TITLE")
    private String movieTitle;

    @Column(name="MOVIE_POSTER")
    private String moviePoster;

    @Column(name="MOVIE_GENRE")
    private String genre;

    @Column(name="DURATION")
    private Integer duration;

    @Column(name="DIRECTOR")
    private String director;

    @Column(name="CAST")
    private List<String> cast;


    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Booking> bookings = new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Ticket> tickets=new ArrayList<>();

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowTime> showTimes=new ArrayList<>();

}
