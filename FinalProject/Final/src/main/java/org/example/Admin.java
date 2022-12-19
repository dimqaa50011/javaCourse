package org.example;

import java.util.Objects;
import java.util.UUID;

public class Admin {
    private String name;
    private String id;

    public Admin(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return name.equals(admin.name) && id.equals(admin.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }
    public void assortmentReplenishment(Store store){
        store.addLaptop(
                new Laptop(
                        "Linux",
                        "ssd",
                        "black",
                        16,
                        512,
                        1000
                )
        );
        store.addLaptop(
                new Laptop(
                        "Linux",
                        "hdd",
                        "silver",
                        8,
                        1024,
                        750
                )
        );
        store.addLaptop(
                new Laptop(
                        "Windows",
                        "hdd",
                        "blue",
                        8,
                        1024,
                        800
                )
        );
        store.addLaptop(
                new Laptop(
                        "Windows",
                        "ssd",
                        "silver",
                        16,
                        512,
                        1300
                )
        );
        store.addLaptop(
                new Laptop(
                        "MacOS",
                        "ssd",
                        "silver",
                        8,
                        512,
                        1500
                )
        );
    }

    @Override
    public String toString() {
        return "Admin{" +
               "name='" + name + '\'' +
               '}';
    }
}