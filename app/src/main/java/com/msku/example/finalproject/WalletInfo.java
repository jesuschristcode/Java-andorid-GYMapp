package com.msku.example.finalproject;

public class WalletInfo {
    private int Balance ;
    public WalletInfo() {

    }



    public WalletInfo(int balance) {
        this.Balance = balance;
    }


    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        this.Balance = balance;
    }
    public String toString() {
        return "Balance " + Balance;
    }
}
