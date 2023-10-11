package com.pwc.onlinebankingsystem.entity;

public class Accountant {
    private String accountantUsername;
    private String accountantEmail;
    private  String accountantPassword;

    public Accountant(String accountantUsername, String accountantEmail, String accountantPassword) {
        super();
        this.accountantUsername = accountantUsername;
        this.accountantEmail = accountantEmail;
        this.accountantPassword = accountantPassword;
    }

    public Accountant() {
        super();
    }

    public String getAccountantUsername() {
        return accountantUsername;
    }

    public String getGetAccountantEmail() {
        return accountantEmail;
    }

    public String getGetAccountantPassword() {
        return accountantPassword;
    }

    public void setAccountantUsername(String accountantUsername) {
        this.accountantUsername = accountantUsername;
    }

    public void setGetAccountantEmail(String accountantEmail) {
        this.accountantEmail = accountantEmail;
    }

    public void setGetAccountantPassword(String accountantPassword) {
        this.accountantPassword = accountantPassword;
    }

    @Override
    public String toString() {
        return "Accountant{" +
                "accountantUsername='" + accountantUsername + '\'' +
                ", AccountantEmail='" + accountantEmail + '\'' +
                ", AccountantPassword='" + accountantPassword + '\'' +
                '}';
    }
}
