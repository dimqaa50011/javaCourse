package org.example;

public class User {
    private String name;

    private int balance;

    private Laptop newLaptop;

    public User(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public Laptop getNewLaptop() {
        return newLaptop;
    }

    public void setNewLaptop(Laptop newLaptop) {
        this.newLaptop = newLaptop;
    }

    public boolean buyALaptop(Laptop laptop){
        return balance >= laptop.getPrice();
    }
    public int purchaseConfirm(Laptop laptop){
        setNewLaptop(laptop);
        return balance - laptop.getPrice();
    }

    @Override
    public String toString() {
        return "User{" +
               "name='" + name + '\'' +
               '}';
    }
}