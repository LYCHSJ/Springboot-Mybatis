package com.alex.springbootmybatishello.mapper;

import com.alex.springbootmybatishello.enums.UserSexEnum;
import com.alex.springbootmybatishello.entity.UserEntity;
import com.alex.springbootmybatishello.param.UserParam;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM users")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    List<UserEntity> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    @Results({
            @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "nickName", column = "nick_name")
    })
    UserEntity getOne(Long id);

    @Insert("INSERT INTO users(userName,passWord, user_sex) VALUES(#{username},#{passWord}),#{userSex})")
    void insert(UserEntity user);

    @Update("UPDATE users SET username=#{userName},nick_name=#{nick_name} WHERE id =#{id}")
    void update(UserEntity user);

    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(Long id);

    @SelectProvider(type = UserSql.class, method = "getList")
    List<UserEntity> getList(UserParam userParam);

    @SelectProvider(type = UserSql.class, method = "getCount")
    int getCount(UserParam userParam);

}
