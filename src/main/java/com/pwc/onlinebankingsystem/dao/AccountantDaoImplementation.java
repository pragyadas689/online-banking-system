package com.pwc.onlinebankingsystem.dao;

import com.pwc.onlinebankingsystem.databaseconnection.DatabaseConnection;
import com.pwc.onlinebankingsystem.entity.Accountant;
import com.pwc.onlinebankingsystem.exception.AccountantException;
import com.pwc.onlinebankingsystem.exception.CustomerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountantDaoImplementation implements AccountantDao{

    @Override
    public Accountant LoginAccountant(String accountantUsername, String accountantPassword) throws AccountantException {
        Accountant acc = null;
        try(Connection conn = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from accountant where accountantUsername = ? and accountantPassword =  ?");

            ps.setString(1,accountantUsername);
            ps.setString(2,accountantPassword);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String n = rs.getString("accountantUsername");
                String e = rs.getString("accountantEmail");
                String p = rs.getString("accountantPassword");

                acc = new Accountant(n,e,p);
            }
        }
        catch (SQLException e){
            throw new AccountantException("Invalid username and Password");
        }
        return acc;
    }

    @Override
    public int addCustomer(String customerName, String customerMail, String customerPassword, String customerMobile, String customerAddress) throws CustomerException {

        int cid = -1;
        try(Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("insert into customerinformation (customerName , customerMail , customerPassword , customerMobile , customerAddress) values(?,?,?,?,?) ");

            ps.setString(1,customerName);
            ps.setString(2,customerMail);
            ps.setString(3,customerPassword);
            ps.setString(4,customerMobile);
            ps.setString(5,customerAddress);

            int x = ps.executeUpdate();
            if(x>0){
                System.out.println("customer successfully added");
            }
            else{
                System.out.println("Customer not added successfully");
            }
        }
        catch (SQLException e){
            System.out.println("SQL Query Related Problem");
        }
        return cid;
    }
}
