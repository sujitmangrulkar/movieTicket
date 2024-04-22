package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.*;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.BookingDtoRequest;
import com.bookmyshow.api.payloads.response.BookingDtoResponse;
import com.bookmyshow.api.repository.*;
import com.bookmyshow.api.service.BookingService;
import com.bookmyshow.api.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class  BookingServiceImpl implements BookingService
{
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CinemaHallRepository cinemaHallRepository;

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private FoodRepository foodRepository;

    @Autowired
    private FoodService foodService;


    @Override
    public BookingDtoResponse createBooking(String userId,String showTimeId, BookingDtoRequest bookingDtoRequest)
    {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        ShowTime showTime = this.showTimeRepository.findById(showTimeId).orElseThrow(() -> new ResourceNotFoundException("ShowTime", "ShowTimeId", showTimeId));
        Movie movie = this.movieRepository.findById(showTime.getMovie().getMovieId()).orElseThrow(() -> new ResourceNotFoundException("Movie", "Movie Id", showTime.getMovie().getMovieId()));
        CinemaHall cinemaHall = this.cinemaHallRepository.findById(showTime.getCinemaHall().getHallId()).orElseThrow(() -> new ResourceNotFoundException("CinemaHall", "HallId", showTime.getCinemaHall().getHallId()));


        Booking map = this.modelMapper.map(bookingDtoRequest, Booking.class);
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setMovie(movie);
        booking.setCinemaHall(cinemaHall);
        booking.setShowTime(showTime);

        //Seats Checking Availability
        List<String> seats= bookingDtoRequest.getSeats();

        List<Seat> bookedSeats = new ArrayList<>();
        for(String seat:seats)
        {
            Seat seat1 = seatRepository.findBySeatName(seat).orElseThrow(() -> new ResourceNotFoundException("Seat", "SeatName", seat));
            bookedSeats.add(seat1);
        }
        System.out.println(bookedSeats);

        booking.setSeats(map.getSeats());
        booking.setBookedSeats(bookedSeats);

        //Calculate Ticket Price

        List<Seat> bookedSeats1 = booking.getBookedSeats();
        Double[] ticketPrice = showTime.getTicketPrice();

        double totalTicketCharges=0;
        double totalAmount=0;
        for(Seat s:bookedSeats1)
        {
            double p1=0;
            switch(s.getSeatType())
            {
                case STANDARD:
                    System.out.println(ticketPrice[0]);
                    p1=ticketPrice[0];
                    break;
                case VIP:
                    System.out.println(ticketPrice[1]);
                    p1=ticketPrice[1];
                    break;
                case PREMIUM:
                    System.out.println(ticketPrice[2]);
                    p1=ticketPrice[2];
                    break;

            }
            totalTicketCharges = totalTicketCharges+p1;
        }


        System.out.println(totalTicketCharges);

        //Food Calculations

        List<String> foodIds = bookingDtoRequest.getFoodIds();
        HashMap<String,Double> foodNameAndPrice = new HashMap<>();
        double foodItemsTotal=0;
        for(String id:foodIds)
        {
            Food food = this.foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food", "Food Id", id));
            foodNameAndPrice.put(food.getItemName(),food.getPrice());
            foodItemsTotal=foodItemsTotal+food.getPrice();
        }
        System.out.println(foodNameAndPrice);
        System.out.println(foodItemsTotal);


        booking.setTotalTicketCharges(totalTicketCharges);
        booking.setTotalFoodCharges(foodItemsTotal);
        booking.setTotalAmount(totalTicketCharges+foodItemsTotal);
        booking.setStatus("CONFIRMED");

        Booking savedBooking = this.bookingRepository.save(booking);




        BookingDtoResponse map1 = this.modelMapper.map(savedBooking, BookingDtoResponse.class);
        map1.setFoodList(foodNameAndPrice);

        return map1;
    }

    @Override
    public List<BookingDtoResponse> getAllBookingDetails()
    {
        List<Booking> allBookings = this.bookingRepository.findAll();

        return allBookings.stream().map((booking) -> modelMapper.map(booking, BookingDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDtoResponse> getBookingsByUserId(String userId)
    {
        List<Booking> allBookingsByUserId = this.bookingRepository.findByUserUserId(userId);

        return allBookingsByUserId.stream().map((booking)->modelMapper.map(booking, BookingDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDtoResponse> getBookingsByMovieId(String movieId)
    {
        List<Booking> bookingsByMovieId = this.bookingRepository.findByMovieMovieId(movieId);
        return bookingsByMovieId.stream().map((booking)->modelMapper.map(booking, BookingDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingDtoResponse> getBookingsByCinemaHallId(String cinemaHallId)
    {
        List<Booking> byCinemaHallHallId = this.bookingRepository.findByCinemaHallHallId(cinemaHallId);

        return byCinemaHallHallId.stream().map((booking)->modelMapper.map(booking, BookingDtoResponse.class)).collect(Collectors.toList());
    }








}
