package com.wxy8866.demo.merchandising;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class TestOp
{

    public static void main(String[] args) throws IOException
    {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try
        {
            Op op = sqlSession.getMapper(Op.class);
            User user = op.getUser(1);
            List<Integer> userProductIDs = user.getProducts();
            System.out.println(userProductIDs.size());

            for (Integer productID : userProductIDs)
            {
                Product product = op.getProduct(productID);
                System.out.format("User %s has bought product %s in catalog %s", user.getUserName(),
                        product.getProductName(),product.getCatalog());
                System.out.println();
            }
        } finally
        {
            sqlSession.close();
        }
    }
}
