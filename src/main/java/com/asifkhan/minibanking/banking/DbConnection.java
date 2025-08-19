package com.asifkhan.minibanking.banking;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Asif Khan <asif.cse12@gmail.com>
 */
public class DbConnection {
    static Connection connection; // Global Connection Object
    public static Connection getConnection()
    {
        try {
            String url= "jdbc:sqlite:c:/sqlite/db/mini-bank.db"; 
            connection = DriverManager.getConnection(url);
        }
        catch (Exception e) {
            System.out.println("Connection Failed!");
        }

        return connection;
    }
}
