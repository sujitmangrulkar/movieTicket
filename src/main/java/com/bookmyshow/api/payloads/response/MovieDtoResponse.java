package com.bookmyshow.api.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDtoResponse
{

    private String movieId;

    private String movieTitle;

    private String moviePoster;

    private String genre;

    private Integer duration;

    private String director;

    private List<String> cast;

}
