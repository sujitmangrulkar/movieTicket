package com.bookmyshow.api.payloads.response;

import com.bookmyshow.api.entity.Food;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse
{
    private String bookingId;

    private String userId;

    private String movieId;

    private String hallId;

    private String showTimeId;

    private List<String> seats;

    private HashMap<String,Double> foodList;

    private Double totalTicketCharges;

    private Double totalFoodCharges;

    private Double totalAmount;

    private String Status;

}
