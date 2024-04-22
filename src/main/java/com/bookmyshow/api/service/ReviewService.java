package com.bookmyshow.api.service;

import com.bookmyshow.api.payloads.request.ReviewDtoRequest;
import com.bookmyshow.api.payloads.response.ReviewDtoResponse;

import java.util.List;

public interface ReviewService
{
    ReviewDtoResponse postReview(ReviewDtoRequest reviewDtoRequest, String userId, String movieId);

    ReviewDtoResponse getReviewByMovieId(String movieId);

    public List<ReviewDtoResponse> getReviewsByUserId(String userId);
    List<ReviewDtoResponse> getReviewsByMovieId(String movieId);
}
