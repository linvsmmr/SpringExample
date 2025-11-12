package com.eunbi.springexample.mybatis.repository;

import com.eunbi.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewRepository {
    // new review 테이블에서 전달받은 id와 일치하는 행 조회
    public Review selectReview(int id);

    public int insertReview(@Param("storeId") int storeId
            , @Param("menu") String menu
            , @Param("userName") String userName
            , @Param("point") double point
            , @Param("review") String review);

    //insert, update, delete 모두 리턴타입 int로 지정(완료된 행의 개수를 리턴할 뿐이니까)


    public int insertReviewByObject(Review review);

}