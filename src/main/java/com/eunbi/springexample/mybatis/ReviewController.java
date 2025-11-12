package com.eunbi.springexample.mybatis;

import com.eunbi.springexample.mybatis.domain.Review;
import com.eunbi.springexample.mybatis.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mybatis/review")
@Controller
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    //id가 3인 리뷰 정보를 response에 담기
    @ResponseBody
    @RequestMapping("/1")
    public Review review(@RequestParam("id") int id) {

        Review review = reviewService.getReview(id);
        return review;
    }

    @ResponseBody
    @RequestMapping("/write")
    public String writeReview()
//            (int storeId
//            , String menu
//            , String userName
//            , double point
//            , String review)

    {

//            int count = reviewService.createReview(4, "치즈피자", "김인규", 4.5, "치즈피자 존맛!");

            Review review = new Review();
            review.setStoreId(2);
            review.setMenu("뿌링클");
            review.setReview("맛잇다");
            review.setPoint(5.0);
            review.setUserName("김인규");

            int count = reviewService.createReviewByObject(review);

            return "입력 성공 : " + count;


    }
}
