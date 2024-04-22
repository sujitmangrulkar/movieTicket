package com.bookmyshow.api.payloads.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class PaymentDtoResponse
{
    private String paymentId;
    private String bookingId;
    private String userId;
    private String cardHolderName;
    private String cardHolderNumber;
    private String cvv;
    private Double amount;
    private String paymentStatus;
    private LocalDateTime paymentTime;
    private LocalDateTime refundGenerationTime;
}
