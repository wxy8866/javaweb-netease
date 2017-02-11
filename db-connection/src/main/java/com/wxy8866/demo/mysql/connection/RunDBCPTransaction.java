package com.wxy8866.demo.mysql.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class RunDBCPTransaction
{
    public static final String    JDBC_CLASS  = "com.mysql.jdbc.Driver";
    public static final String    DB_URL      = "jdbc:mysql://localhost:3306/netease?useSSL=false";
    public static final String    DB_USER     = "root";
    public static final String    DB_PASSWORD = "wxy967351";

    public static BasicDataSource dataSource  = null;

    public static void main(String[] args)
    {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String deleteQuery = "delete from curriculum where username = ? and coursename = ?";
        String insertQuery = "insert into curriculum(username,coursename) values(?,?)";

        dataSource = new BasicDataSource();
        dataSource.setUsername(DB_USER);
        dataSource.setPassword(DB_PASSWORD);
        dataSource.setUrl(DB_URL);
        dataSource.setDriverClassName(JDBC_CLASS);
        dataSource.setInitialSize(5);
        dataSource.setMinIdle(1);
        dataSource.setMaxIdle(10);

        try
        {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, "ZhangSan");
            preparedStatement.setString(2, "Math");
            preparedStatement.execute();
            preparedStatement.close();
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, "LiSi");
            preparedStatement.setString(2, "Math");
            preparedStatement.execute();
            connection.commit();
        } catch (SQLException e)
        {
            System.out.println("Error occurs. Roll back entire transaction");
            e.printStackTrace();
            try
            {
                if (connection != null)
                    connection.rollback();
            } catch (SQLException e1)
            {
                System.err.println("rollback failure");
                e1.printStackTrace();
            }
        } finally
        {
            try
            {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

    }

}
