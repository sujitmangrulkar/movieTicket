package com.bookmyshow.api.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name="PAYMENT_DTLS")
@Getter
@Setter
@NoArgsConstructor
public class Payment
{
    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private String paymentId;

//    @Column(name="BOOKING_ID")
//    private String bookingId;

    @Column(name="CARD_HOLDER_NAME")
    private String cardHolderName;

    @Column(name="CARD_HOLDER_NUMBER")
    private String cardHolderNumber;

    @Column(name="CVV")
    private String cvv;

    @Column(name="AMOUNT")
    private Double amount;

    @Column(name="PAYMENT_STATUS")
    private String paymentStatus;

    @Column(name="PAYMENT_TIME")
    private LocalDateTime paymentTime;

    @Column(name="REFUND_GENERATED_ON")
    private LocalDateTime refundGenerationTime;

    @ManyToOne
    private User user;

    @OneToOne
    private Booking booking;

    @OneToOne(mappedBy ="payment")
    private Ticket ticket;


}
