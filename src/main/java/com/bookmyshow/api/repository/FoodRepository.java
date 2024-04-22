package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,String>
{
}
