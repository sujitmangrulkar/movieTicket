package com.bookmyshow.api.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDtoResponse
{
    private String reviewId;

    private String userID;

    private String movieId;

    private float rating;

    private String comment;

    private LocalDateTime timeStamp;
}
