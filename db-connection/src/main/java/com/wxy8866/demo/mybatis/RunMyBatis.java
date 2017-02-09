package com.wxy8866.demo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class RunMyBatis
{
    public static void main(String[] args) throws IOException
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        Configuration configuration = sqlSessionFactory.getConfiguration();
        configuration.addMapper(GetUserInfo.class);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            GetUserInfo getUserInfo = sqlSession.getMapper(GetUserInfo.class);
            User user = new User("XiaoMing", "Netease");
            getUserInfo.addUser(user);
            System.out.println(user.getId());
            // user = getUserInfo.getUser(user.getId());
            // user.setUserName("LiMing");
            // getUserInfo.updateUser(user);
            // getUserInfo.deleteUser(user.getId());
        } catch (NullPointerException nullPointerException)
        {
            System.err.println("No such user");
        } finally
        {
            sqlSession.close();
        }
    }

}
