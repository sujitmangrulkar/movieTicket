package com.bookmyshow.api.controller;

import com.bookmyshow.api.payloads.request.FoodDtoRequest;
import com.bookmyshow.api.payloads.response.FoodDtoResponse;
import com.bookmyshow.api.service.FoodService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodController
{
    @Autowired
    private FoodService foodService;

    @PostMapping("/addItem")
    public ResponseEntity<FoodDtoResponse> addFoodItem(@RequestBody FoodDtoRequest foodDtoRequest)
    {
        FoodDtoResponse foodDtoResponse = this.foodService.addNewFood(foodDtoRequest);

        return new ResponseEntity<>(foodDtoResponse, HttpStatus.CREATED);

    }
}
