package com.eunbi.springexample.mybatis.service;

import com.eunbi.springexample.mybatis.domain.Review;
import com.eunbi.springexample.mybatis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public Review getReview(int id) {
        // new_review에서 id가 3인 행 조회
        Review review = reviewRepository.selectReview(id);

        return review;
    }
}
