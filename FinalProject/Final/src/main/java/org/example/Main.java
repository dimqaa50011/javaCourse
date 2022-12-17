package org.example;

public class Main {

    public static void main(String[] args) {
        Store store = new Store("Best Laptops");
        Admin admin = new Admin("Alex");
        Seller seller = new Seller("Sam");

        admin.assortmentReplenishment(store);
        seller.setStore(store);

        store.addBuyer(new User("Alice", 1300));
        store.addBuyer(new User("Ann", 1800));
        store.addBuyer(new User("John", 900));
        store.addBuyer(new User("Scherlock", 1100));

        for(User buyer : store.getBuyers()) {
            seller.sale(buyer);
        }

    }
}