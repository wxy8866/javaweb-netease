package com.wxy8866.demo.mysql.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class RunDBCP
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
        String query = "select * from Product where id = ?";

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
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 1);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                System.out.format("product name: %s | inventory: %d", resultSet.getString("ProductName"),
                        resultSet.getInt("Inventory"));
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
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
