package com.bookmyshow.api.repository;

import com.bookmyshow.api.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,String>
{
    public List<Review> findByUserUserId(String userId);

    public List<Review> findByMovieMovieId(String movieId);
}
