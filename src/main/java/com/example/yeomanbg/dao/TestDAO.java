package com.example.yeomanbg.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TestDAO {

    @Select("select * from j_user where id= #{userId}")
    Map<String,String> test(@Param("userId")int userId);

    @Select("select * from area where parent_id is null")
    List<Map<String,String>> testSecond();

}
