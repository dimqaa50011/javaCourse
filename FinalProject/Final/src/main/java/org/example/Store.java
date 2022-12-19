package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Store {
    private String name;
    private Set<Laptop> assortment = new HashSet<>();

    private Deque<User> buyers = new ArrayDeque<>();

    public Store(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public Set<Laptop> getAssortment() {
        return assortment;
    }

    public Deque<User> getBuyers() {
        return buyers;
    }

    public void addBuyer(User buyer){
        buyers.addLast(buyer);
    }


    public void addLaptop(Laptop laptop) {
        this.assortment.add(laptop);
    }

    @Override
    public String toString() {
        return "Store{" +
               "name='" + name + '\'' +
               '}';
    }
}