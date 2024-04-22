package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.PaymentDtoRequest;
import com.bookmyshow.api.payloads.response.PaymentDtoResponse;

import java.util.List;

public interface PaymentService
{
    PaymentDtoResponse processPayment(PaymentDtoRequest paymentDtoRequest,String paymentId);

    PaymentDtoResponse refundPayment(PaymentDtoRequest paymentDtoRequest, String paymentId);
    List<PaymentDtoResponse> getPaymentsByUserId(String userId);

    PaymentDtoResponse getPaymentsByBookingId(String bookingId);

}
