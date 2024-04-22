package com.bookmyshow.api.payloads.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDtoRequest
{
    //private String reviewId;

//    private String userID;
//
//    private String movieId;

    //@NotEmpty
    private float rating;

    //@NotEmpty
    private String comment;

    //private LocalDateTime timeStamp;
}
