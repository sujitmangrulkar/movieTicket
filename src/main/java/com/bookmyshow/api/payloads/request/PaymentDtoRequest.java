package com.bookmyshow.api.payloads.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDtoRequest
{
//    private String paymentId;
//    //private String bookingId;
//    //private String userId;
//    private Double amount;
//    private String paymentStatus;
//    private LocalDateTime paymentTime;
//    private LocalDateTime refundGenerationTime;

    private String cardHolderName;
    private String cardHolderNumber;
    private String cvv;
}
