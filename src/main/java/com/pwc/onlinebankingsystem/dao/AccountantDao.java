package com.pwc.onlinebankingsystem.dao;

import com.pwc.onlinebankingsystem.entity.Accountant;
import com.pwc.onlinebankingsystem.exception.AccountantException;
import com.pwc.onlinebankingsystem.exception.CustomerException;

public interface AccountantDao {
       public Accountant LoginAccountant(String accountantUsername,String accountantPassword)  throws AccountantException ;
       public int addCustomer(String customerName,String customerMail,String customerPassword,String customerMobile,String customerAddress) throws CustomerException;
}
