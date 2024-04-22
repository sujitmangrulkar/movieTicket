package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Booking;
import com.bookmyshow.api.entity.Payment;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.PaymentDtoRequest;
import com.bookmyshow.api.payloads.response.PaymentDtoResponse;
import com.bookmyshow.api.repository.BookingRepository;
import com.bookmyshow.api.repository.PaymentRepository;
import com.bookmyshow.api.service.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public PaymentDtoResponse processPayment(PaymentDtoRequest paymentDtoRequest, String bookingId1)
    {
        Booking booking = this.bookingRepository.findById(bookingId1).orElseThrow(() -> new ResourceNotFoundException("Booking", "Booking Id", bookingId1));
        Payment payment = this.modelMapper.map(paymentDtoRequest, Payment.class);


        payment.setBooking(booking);
        payment.setUser(booking.getUser());
        payment.setAmount(booking.getTotalAmount());
        payment.setPaymentTime(LocalDateTime.now());
        payment.setPaymentStatus("Payment Completed");

        Payment savedPayment = this.paymentRepository.save(payment);

        return this.modelMapper.map(savedPayment, PaymentDtoResponse.class);
    }

    @Override
    public PaymentDtoResponse refundPayment(PaymentDtoRequest paymentDtoRequest, String paymentId)
    {
        Payment payment = this.paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "PaymentId", paymentId));

        payment.setRefundGenerationTime(LocalDateTime.now());
        payment.setPaymentStatus("REFUND GENERATED");

        Payment refundedPayment = this.paymentRepository.save(payment);

        return this.modelMapper.map(refundedPayment, PaymentDtoResponse.class);
    }
    @Override
    public List<PaymentDtoResponse> getPaymentsByUserId(String userId)
    {
        List<Payment> byUserUserId = this.paymentRepository.findByUserUserId(userId);

        return byUserUserId.stream().map((payment)->modelMapper.map(payment, PaymentDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public PaymentDtoResponse getPaymentsByBookingId(String bookingId)
    {
        Payment paymentByBookingId = this.paymentRepository.findByBookingBookingId(bookingId);

        return this.modelMapper.map(paymentByBookingId, PaymentDtoResponse.class);

    }
}
