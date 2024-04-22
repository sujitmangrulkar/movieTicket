package com.bookmyshow.api.service;

import com.bookmyshow.api.entity.Booking;
import com.bookmyshow.api.payloads.request.FoodDtoRequest;
import com.bookmyshow.api.payloads.response.FoodDtoResponse;

public interface FoodService
{
    FoodDtoResponse addNewFood(FoodDtoRequest foodDtoRequest);
    FoodDtoResponse updateFoodDetails(Booking booking, String foodId);
}
