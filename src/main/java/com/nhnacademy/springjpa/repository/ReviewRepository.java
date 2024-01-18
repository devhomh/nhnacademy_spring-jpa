package com.nhnacademy.springjpa.repository;

import com.nhnacademy.springjpa.domain.ReviewDto;
import com.nhnacademy.springjpa.entity.Review;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> getReviewByRatingGreaterThanEqual(int rating);

    Page<ReviewDto> getReviewByUser_UserName(Pageable pageable);

    Page<ReviewDto> getReviewByProduct_ModelName(Pageable pageable);

}
