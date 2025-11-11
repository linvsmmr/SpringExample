package com.eunbi.springexample.mybatis.repository;

import com.eunbi.springexample.mybatis.domain.Review;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewRepository {
    // new review 테이블에서 전달받은 id와 일치하는 행 조회
    public Review selectReview(int id);
}