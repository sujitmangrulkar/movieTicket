package com.bookmyshow.api.payloads.request;

import com.bookmyshow.api.entity.Food;
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
public class BookingDtoRequest
{
    //private String bookingId;

    //private String userId;

    //private String movieId;

    //private String hallId;

    //private String showTimeId;


    private List<String> seats;

    private List<String> foodIds;

  //  private Double totalAmount;

   // private String Status;

}
