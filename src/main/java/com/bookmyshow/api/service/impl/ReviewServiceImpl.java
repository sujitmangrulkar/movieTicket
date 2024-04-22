package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Movie;
import com.bookmyshow.api.entity.Review;
import com.bookmyshow.api.entity.User;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.ReviewDtoRequest;
import com.bookmyshow.api.payloads.response.ReviewDtoResponse;
import com.bookmyshow.api.repository.MovieRepository;
import com.bookmyshow.api.repository.ReviewRepository;
import com.bookmyshow.api.repository.UserRepository;
import com.bookmyshow.api.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService
{
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ReviewDtoResponse postReview(ReviewDtoRequest reviewDtoRequest, String userId, String movieId)
    {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        Movie movie = this.movieRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Movie", "MovieId", movieId));

        Review review = this.modelMapper.map(reviewDtoRequest, Review.class);

        review.setUser(user);
        review.setMovie(movie);
        review.setTimeStamp(LocalDateTime.now());

        Review savedReview = this.reviewRepository.save(review);

        return modelMapper.map(savedReview, ReviewDtoResponse.class);
    }

    @Override
    public ReviewDtoResponse getReviewByMovieId(String movieId)
    {
        Review review = this.reviewRepository.findById(movieId).orElseThrow(() -> new ResourceNotFoundException("Review", "ReviewId", movieId));

        return modelMapper.map(review, ReviewDtoResponse.class);
    }

    @Override
    public List<ReviewDtoResponse> getReviewsByUserId(String userId)
    {
        List<Review> reviewsByUserId = this.reviewRepository.findByUserUserId(userId);

        return reviewsByUserId.stream().map((review)->modelMapper.map(review, ReviewDtoResponse.class)).collect(Collectors.toList());
    }

    @Override
    public List<ReviewDtoResponse> getReviewsByMovieId(String movieId)
    {
        List<Review> reviewsByMovieId=this.reviewRepository.findByMovieMovieId(movieId);
        return reviewsByMovieId.stream().map((review)->modelMapper.map(review, ReviewDtoResponse.class)).collect(Collectors.toList());
    }
}
