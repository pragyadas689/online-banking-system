package com.pwc;

import com.pwc.onlinebankingsystem.dao.AccountantDao;
import com.pwc.onlinebankingsystem.dao.AccountantDaoImplementation;
import com.pwc.onlinebankingsystem.entity.Accountant;
import com.pwc.onlinebankingsystem.exception.CustomerException;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        Scanner sc = new Scanner(System.in);

        boolean f = true;

        while(f){
            System.out.println("---------Welcome To Online Banking System-------------");
            System.out.println("------------------------------------------------------");
            System.out.println("1. ADMIN LOGIN PORTAL\r\n"
            +"2. CUSTOMER");

            System.out.println("Choose Your Option ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 :
                    System.out.println("Admin Login Credential-----------------------Accountant");
                    System.out.println("Enter your UserName");
                    String username = sc.next();
                    System.out.println("Enter your Password");
                    String pass = sc.next();

                    AccountantDao ad= new AccountantDaoImplementation();
                    try{
                        Accountant a = ad.LoginAccountant(username,pass);
                        if(a==null){
                            System.out.println("Invalid credentail");
                            break;
                        }
                        System.out.println("Login successfully!!!!!!!!");
                        System.out.println("Welcome to : "+a.getAccountantUsername() + " as Admin of Online Banking System");

                        boolean y = true;

                        while (y) {
                            System.out.println("-------------------------------------------\r\n"
                                    +"1. Add New Customer Account \r\n"
                            );

                            int x = sc.nextInt();
                            if(x==1){
                                System.out.println("----------New Account---------");
                                System.out.println("Enter Customer name");
                                String a1 = sc.next();
                                System.out.println("Enter customer Mail");
                                String a2 = sc.next();
                                System.out.println("Enter customer Password");
                                String a3 = sc.next();
                                System.out.println("Enter customer mobile Number");
                                String a4 = sc.next();
                                System.out.println("Enter customer address");
                                String a5 = sc.next();

                                int s1 = -1;

                                try{
                                    s1 = ad.addCustomer(a1,a2,a3,a4,a5);
                                }
                                catch (CustomerException e){
                                    System.out.println(e.getMessage());
                                }
                                System.out.println("----------------------------------------");
                            }
                        }
                    }
                    catch (Exception e){

                    }
            }
        }
    }
}
