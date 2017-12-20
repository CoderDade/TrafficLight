package com.dade.trafficlight.mybatis.test;

import com.dade.trafficlight.mybatis.annotation.MybatisTL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TLUserDao {

    @Select("<script>" +
            "select user_name userName, user_age userAge from tl_user" +
            "</script>")
    @MybatisTL(type = TLUserEntity.class, collection = List.class)
    List<TLUserEntity> queryTLUser();

}
