package com.wxy8866.demo.mybatis;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface GetUserInfo
{
    @Select("select * from user where id = #{id}")
    public User getUser(int id);
    @Update("update user set userName = #{userName} , corp = #{corp} where id = #{id}")
    public void updateUser(User user);
    @Delete("delete from user where id = #{id}")
    public void deleteUser(int id);
    @Insert("insert into user (userName,corp) values (#{userName},#{corp})")
    public void addUser(User user);
}
