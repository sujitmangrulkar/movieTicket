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
public class TicketDtoResponse
{
    private String ticketId;
    private String paymentId;
    private String bookingId;
    private String userId;
    private String movieId;
    private String hallId;
    private List<String> seatNumbers;
}
