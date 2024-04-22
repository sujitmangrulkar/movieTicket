package com.bookmyshow.api.service.impl;

import com.bookmyshow.api.entity.Booking;
import com.bookmyshow.api.entity.Food;
import com.bookmyshow.api.exceptions.ResourceNotFoundException;
import com.bookmyshow.api.payloads.request.FoodDtoRequest;
import com.bookmyshow.api.payloads.response.FoodDtoResponse;
import com.bookmyshow.api.repository.FoodRepository;
import com.bookmyshow.api.service.FoodService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FoodServiceImpl implements FoodService
{
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private FoodRepository foodRepository;
    @Override
    public FoodDtoResponse addNewFood(FoodDtoRequest foodDtoRequest)
    {
        Food food = this.modelMapper.map(foodDtoRequest, Food.class);
        Food savedFood = this.foodRepository.save(food);
        return this.modelMapper.map(savedFood,FoodDtoResponse.class);
    }

    @Override
    public FoodDtoResponse updateFoodDetails(Booking booking,String foodId)
    {
        Food food = this.foodRepository.findById(foodId).orElseThrow(() -> new ResourceNotFoundException("Food", "FoodId", foodId));
        //food.setBooking(booking);
        Food savedFood = this.foodRepository.save(food);

        return this.modelMapper.map(savedFood,FoodDtoResponse.class);
    }
}
