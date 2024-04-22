package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.PaymentDtoRequest;
import com.bookmyshow.api.payloads.response.PaymentDtoResponse;
import com.bookmyshow.api.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController
{
    @Autowired
    private PaymentService paymentService;
    @PostMapping("/{bookingId}")
    public ResponseEntity<PaymentDtoResponse> newPayment(@RequestBody PaymentDtoRequest paymentDtoRequest, @PathVariable String bookingId)
    {
        PaymentDtoResponse paymentDtoResponse = this.paymentService.processPayment(paymentDtoRequest,bookingId);

        return new ResponseEntity<>(paymentDtoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{paymentId}")
    public ResponseEntity<PaymentDtoResponse> refundProcess(@Valid @RequestBody PaymentDtoRequest paymentDtoRequest, @PathVariable String paymentId)
    {
        PaymentDtoResponse paymentDtoResponse1 = this.paymentService.refundPayment(paymentDtoRequest, paymentId);

        return new ResponseEntity<>(paymentDtoResponse1,HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<PaymentDtoResponse>> getPaymentsByUserId(@PathVariable String userId)
    {
        List<PaymentDtoResponse> paymentsByUserId = this.paymentService.getPaymentsByUserId(userId);

        return new ResponseEntity<>(paymentsByUserId,HttpStatus.OK);
    }

    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<PaymentDtoResponse> getPaymentByBookingId(@PathVariable String bookingId)
    {
        PaymentDtoResponse paymentsByBookingId = this.paymentService.getPaymentsByBookingId(bookingId);

        return new ResponseEntity<>(paymentsByBookingId,HttpStatus.OK);
    }
}
