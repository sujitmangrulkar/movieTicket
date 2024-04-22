package com.bookmyshow.api.payloads.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDtoRequest
{

    //@NotEmpty
    private String movieTitle;

    private String moviePoster;

    //@NotEmpty
    private String genre;

    //@NotEmpty
    private Integer duration;

    //@NotEmpty
    private String director;

    //@NotEmpty
    private List<String> cast;

}
