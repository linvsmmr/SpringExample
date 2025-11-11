package com.eunbi.springexample.mybatis;

import com.eunbi.springexample.mybatis.domain.Review;
import com.eunbi.springexample.mybatis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //id가 3인 리뷰 정보를 response에 담기
    @ResponseBody
    @RequestMapping("/mybatis/review")
    public Review review(@RequestParam("id") int id) {

        Review review = reviewService.getReview(id);
        return review;
    }
}
