package com.dade.trafficlight.client.dal;

import com.dade.trafficlight.mybatis.annotation.MybatisTL;
import com.dade.trafficlight.mybatis.util.AnnotationUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;

@Mapper
public interface TLUserDao {

    @Select("<script>" +
            "select user_name userName, user_age userAge from tl_user" +
            "</script>")
    @MybatisTL(type = TLUserEntity.class, collection = List.class, tagetClass = TLUserDao.class)
    List<TLUserEntity> queryTLUser();

}
