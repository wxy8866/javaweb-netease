package com.wxy8866.demo.mysql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RunJDBC
{

    public static final String JDBC_CLASS  = "com.mysql.jdbc.Driver";
    public static final String DB_URL      = "jdbc:mysql://localhost:3306/netease?useSSL=false";
    public static final String DB_USER     = "root";
    public static final String DB_PASSWORD = "wxy967351";

    public static void main(String[] args) throws ClassNotFoundException
    {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;

        Class.forName(JDBC_CLASS);
        try
        {
            String query = "select * from Product where id = ?";
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
