package com.pwc.onlinebankingsystem.dao;

import com.pwc.onlinebankingsystem.entity.Accountant;
import com.pwc.onlinebankingsystem.exception.AccountantException;
import com.pwc.onlinebankingsystem.exception.CustomerException;
import com.pwc.onlinebankingsystem.entity.Customer;

public interface AccountantDao {
       public Accountant LoginAccountant(String accountantUsername,String accountantPassword)  throws AccountantException ;
       public int addCustomer(String customerName,String customerMail,String customerPassword,String customerMobile,String customerAddress) throws CustomerException;
       public String addAccount(int customerBalance,int cid) throws CustomerException;
       public String updateCustomer(int customerAccountNumber, String customerAddress) throws CustomerException;
       public String deleteAccount (int customerAccountNumber) throws CustomerException;
       public Customer viewCustomer (int customerAccountNumber) throws CustomerException;

       public Customer viewAllCustomer() throws CustomerException;



}
