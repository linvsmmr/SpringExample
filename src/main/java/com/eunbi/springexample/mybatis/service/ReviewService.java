package com.eunbi.springexample.mybatis.service;

import com.eunbi.springexample.mybatis.domain.Review;
import com.eunbi.springexample.mybatis.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    // 전달 받은 id와 일치하는 리뷰정보 얻어오기
    public Review getReview(int id) {

        // new_review 테이블에서  전달받은 id와 일치하는 행 조회
        Review review = reviewRepository.selectReview(id);

        return review;
    }

    public int createReview(
            int storeId
            , String menu
            , String userName
            , double point
            , String review) {

        int count = reviewRepository.insertReview(storeId, menu, userName, point, review);

        return count;
    }

    public int createReviewByObject(Review review) {

        int count = reviewRepository.insertReviewByObject(review);

        return count;
    }
}