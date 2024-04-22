package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="REVIEW_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String reviewId;

//    @Column(name="USER_ID")
//    private String userID;
//
//    @Column(name="MOVIE_ID")
//    private String movieId;

    @Column(name="Rating")
    private float rating;

    @Column(name="COMMENTS")
    private String comment;

    @Column(name="TIMESTAMP")
    private LocalDateTime timeStamp;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

}
