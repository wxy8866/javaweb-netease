package com.wxy8866.demo.mysql.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class XiaoMingBuy
{
    public static final String    JDBC_CLASS           = "com.mysql.jdbc.Driver";
    public static final String    DB_URL               = "jdbc:mysql://localhost:3306/netease?useSSL=false";
    public static final String    DB_USER              = "root";
    public static final String    DB_PASSWORD          = "wxy967351";

    public static final String    GET_INVENTORY_SQL    = "SELECT INVENTORY FROM INVENTORY WHERE PRODUCTNAME = ?";
    public static final String    CHANGE_INVENTORY_SQL = "UPDATE INVENTORY SET INVENTORY = INVENTORY - 1 WHERE PRODUCTNAME = ?";
    public static final String    CREATE_ORDER_RECORD  = "INSERT INTO ORDER2 (BUYER,PRODUCTNAME) VALUES (?,?)";

    public static BasicDataSource dataSource           = null;

    @SuppressWarnings("resource")
    public static void main(String[] args)
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int inventory = 0;

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

            preparedStatement = connection.prepareStatement(GET_INVENTORY_SQL);
            preparedStatement.setString(1, "bag");
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                inventory = resultSet.getInt("Inventory");
            }

            if (inventory > 0)
            {
                preparedStatement = connection.prepareStatement(CHANGE_INVENTORY_SQL);
                preparedStatement.setString(1, "bag");
                preparedStatement.execute();
                preparedStatement = connection.prepareStatement(CREATE_ORDER_RECORD);
                preparedStatement.setString(1, "xiaoming");
                preparedStatement.setString(2, "bag");
                preparedStatement.execute();
            }
            connection.commit();
        } catch (SQLException e)
        {
            e.printStackTrace();
            if (connection != null)
                try
                {
                    System.out.println("Rollback whole transaction");
                    connection.rollback();
                } catch (SQLException e1)
                {
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
                System.err.println("Error occur when release the resources");
                e.printStackTrace();
            }
        }
    }
}
