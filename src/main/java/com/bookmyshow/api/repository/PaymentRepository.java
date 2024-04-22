package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String>
{
    public List<Payment> findByUserUserId(String userId);

    public Payment findByBookingBookingId(String bookingId);

}
