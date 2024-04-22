package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.ReviewDtoRequest;
import com.bookmyshow.api.payloads.response.ReviewDtoResponse;
import com.bookmyshow.api.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController
{
    @Autowired
    private ReviewService reviewService;
    @PostMapping("/{userId}/{movieId}")
    public ResponseEntity<ReviewDtoResponse> postReview(@Valid @RequestBody ReviewDtoRequest reviewDtoRequest, @PathVariable String userId, @PathVariable String movieId)
    {
        ReviewDtoResponse reviewDtoResponse = this.reviewService.postReview(reviewDtoRequest, userId, movieId);

        return new ResponseEntity<>(reviewDtoResponse, HttpStatus.CREATED);
    }

    @GetMapping("reviewId/{reviewId}")
    public ResponseEntity<ReviewDtoResponse> getReviewById(@PathVariable String reviewId)
    {
        ReviewDtoResponse reviewByMovieId = this.reviewService.getReviewByMovieId(reviewId);

        return new ResponseEntity<>(reviewByMovieId,HttpStatus.OK);
    }

    @GetMapping("userId/{userId}")
    public ResponseEntity<List<ReviewDtoResponse>> getReviewsByUserId(@PathVariable String userId)
    {
        List<ReviewDtoResponse> reviewsByUserId = this.reviewService.getReviewsByUserId(userId);

        return new ResponseEntity<>(reviewsByUserId,HttpStatus.OK);
    }

    @GetMapping("/movieId/{movieId}")
    public ResponseEntity<List<ReviewDtoResponse>> getReviewsByMovieId(@PathVariable String movieId)
    {
        List<ReviewDtoResponse> reviewsByMovieId = this.reviewService.getReviewsByMovieId(movieId);

        return new ResponseEntity<>(reviewsByMovieId,HttpStatus.OK);
    }


}
