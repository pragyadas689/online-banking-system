package com.pwc.onlinebankingsystem.dao;

import com.pwc.onlinebankingsystem.entity.Customer;
import com.pwc.onlinebankingsystem.exception.CustomerException;

public interface CustomerDao {
    public Customer LoginCustomer(String customerName,String customerPassword) throws CustomerException;

    public int viewBalance(int customerAccountNumber) throws CustomerException;

    public int Deposit(int customerAccountNumber , int amount) throws CustomerException;

    public int Withdraw(int customerAccountNumber,int amount) throws CustomerException;

    public int Transfer(int customerAccountNumber, int amount , int customerAccountNumber2) throws CustomerException;

}
