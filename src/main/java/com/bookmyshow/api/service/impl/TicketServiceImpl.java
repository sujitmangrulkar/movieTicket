package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Booking;
import com.bookmyshow.api.entity.Payment;
import com.bookmyshow.api.entity.Ticket;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.TicketDtoRequest;
import com.bookmyshow.api.payloads.response.TicketDtoResponse;
import com.bookmyshow.api.repository.BookingRepository;
import com.bookmyshow.api.repository.PaymentRepository;
import com.bookmyshow.api.repository.TicketRepository;
import com.bookmyshow.api.service.TicketService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public TicketDtoResponse generateTicket(String paymentId)
    {
        Payment payment = this.paymentRepository.findById(paymentId).orElseThrow(() -> new ResourceNotFoundException("Payment", "Payment Id", paymentId));

        Booking booking = bookingRepository.findById(payment.getBooking().getBookingId()).orElseThrow(() -> new ResourceNotFoundException("Booking", "BookingId",payment.getBooking().getBookingId()));

        Ticket ticket=new Ticket();

        ticket.setBooking(booking);
        ticket.setPayment(payment);
        ticket.setUser(booking.getUser());
        ticket.setMovie(booking.getMovie());
        ticket.setCinemaHall(booking.getCinemaHall());
        ticket.setSeatNumbers(booking.getSeats());

        Ticket savedTicket = this.ticketRepository.save(ticket);

        return this.modelMapper.map(savedTicket, TicketDtoResponse.class);
    }

    @Override
    public List<TicketDtoResponse> getAllTickets() {
        List<Ticket> allTickets = this.ticketRepository.findAll();

        return allTickets.stream().map((ticket) -> modelMapper.map(ticket, TicketDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<TicketDtoResponse> getTicketsByUserId(String userId) {
        List<Ticket> ticketsByUserId = this.ticketRepository.findByUserUserId(userId);

        return ticketsByUserId.stream().map((ticket) -> modelMapper.map(ticket, TicketDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<TicketDtoResponse> getTicketByMovieId(String movieId)
    {
        List<Ticket> ticketByMovieId=this.ticketRepository.findByMovieMovieId(movieId);
        return ticketByMovieId.stream().map((ticket)->modelMapper.map(ticket, TicketDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<TicketDtoResponse> getTicketsByCinemaHallId(String cinemaHallId)
    {
        List<Ticket> byCinemaHallHallId = this.ticketRepository.findByCinemaHallHallId(cinemaHallId);

        return byCinemaHallHallId.stream().map((ticket)->modelMapper.map(ticket, TicketDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public TicketDtoResponse getTicketByBookingId(String bookingId)
    {
        Ticket ticketByBookingId = this.ticketRepository.findByBookingBookingId(bookingId);
        return this.modelMapper.map(ticketByBookingId, TicketDtoResponse.class);
    }


}