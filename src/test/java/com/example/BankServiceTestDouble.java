package com.example;

/**
 * @author Angela Gustafsson, anggus-1
 */
public class BankServiceTestDouble implements BankService{
    @Override
    public void pay(String id, double amount) {
        if (id.equals("Farbror")) {
            throw new RuntimeException();
        }

    }
}
