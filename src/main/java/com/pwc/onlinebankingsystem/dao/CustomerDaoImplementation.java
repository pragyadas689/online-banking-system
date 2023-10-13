package com.pwc.onlinebankingsystem.dao;

import com.pwc.onlinebankingsystem.databaseconnection.DatabaseConnection;
import com.pwc.onlinebankingsystem.entity.Customer;
import com.pwc.onlinebankingsystem.exception.CustomerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImplementation implements CustomerDao{
    @Override
    public Customer LoginCustomer(String customerName, String customerPassword) throws CustomerException {
        Customer cu = null;
        try(Connection conn  = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from customerinformation i inner join account a on i.cid=a.cid where customerName = ? and customerPassword = ? ");

            ps.setString(1,customerName);
            ps.setString(2,customerPassword);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                int a = rs.getInt("customerAccountNumber");
                String n = rs.getString("customerName");
                int b = rs.getInt("customerBalance");
                String e = rs.getString("customerPassword");
                String p = rs.getString("customerMail");
                String  m = rs.getString("customerMobile");
                String ad = rs.getString("customerAddress");

                cu = new Customer(a,n,b,e,p,m,ad);
            }
            else{
                System.out.println("Invalid Credential..........");
            }
        }
        catch (SQLException e){
            throw new CustomerException(e.getMessage());
        }
        return cu;
    }

    @Override
    public int viewBalance(int customerAccountNumber) throws CustomerException {
        int b = -1;
        try(Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("select customerBalance from account where customerAccountNumber = ? ");

            ps.setInt(1,customerAccountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                 b = rs.getInt("customerBalance");
            }
            else{
                System.out.println("Invalid account number!!!!!");
            }

        }
        catch (SQLException e){
            throw new CustomerException(e.getMessage());
        }
        return b;
    }

    @Override
    public int Deposit(int customerAccountNumber, int amount) throws CustomerException {
        int b = -1;
        try(Connection conn = DatabaseConnection.provideConnection()) {
            PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance + ? where customerAccountNumber = ?  ");

            ps.setInt(1,amount);
            ps.setInt(2,customerAccountNumber);

            int rs = ps.executeUpdate();



        }
        catch (SQLException e){
            throw new CustomerException(e.getMessage());
        }
        return b;
    }

    @Override
    public int Withdraw(int customerAccountNumber, int amount) throws CustomerException {
        int vb = viewBalance(customerAccountNumber);

        if(vb>amount){
            try(Connection conn = DatabaseConnection.provideConnection()) {
                PreparedStatement ps = conn.prepareStatement("update account set customerBalance = customerBalance - ? where customerAccountNumber = ?  ");

                ps.setInt(1,amount);
                ps.setInt(2,customerAccountNumber);

                int rs = ps.executeUpdate();



            }
            catch (SQLException e){
                throw new CustomerException(e.getMessage());
            }
        }
        else{
            System.out.println("insufficient balance!!!!!!!!!!!!!!");
        }
        return vb+amount;
    }

    @Override
    public int Transfer(int customerAccountNumber, int amount, int customerAccountNumber2) throws CustomerException {
        int vb = viewBalance(customerAccountNumber);

        if (vb > amount && checkAccount(customerAccountNumber2)) {
            int wit = Withdraw(customerAccountNumber,amount);
            int dep = Deposit(customerAccountNumber2,amount);

        } else {
            throw new CustomerException("Insufficient balance");
        }
        return 0;
    }

        private boolean checkAccount(int customerAccountNumber1){
        try(Connection conn  = DatabaseConnection.provideConnection()){
            PreparedStatement ps = conn.prepareStatement("select * from account where customerAccountNumber = ? ");
            ps.setInt(1,customerAccountNumber1);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
            return false;
        }

}
