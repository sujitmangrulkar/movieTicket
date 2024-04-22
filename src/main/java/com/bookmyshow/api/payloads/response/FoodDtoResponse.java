package com.bookmyshow.api.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodDtoResponse
{
    private String foodItemId;
    private String itemName;
    private Double price;

}
