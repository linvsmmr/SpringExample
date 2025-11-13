package com.eunbi.springexample.mvc;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    public User selectLastUser();
    public int insertUser(@Param("name") String name,
                      @Param("birthday") String birthday,
                      @Param("email") String email,
                      @Param("introduce") String introduce);

}
