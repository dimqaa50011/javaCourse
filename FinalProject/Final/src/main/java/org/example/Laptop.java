package org.example;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Laptop {
    private String os;
    private String typeDisc;
    private String color;
    private int ram;
    private int memoryDisc;
    private int price;

    public Laptop(String os, String typeDisc, String color, int ram, int memoryDisc, int price) {
        this.os = os;
        this.typeDisc = typeDisc;
        this.color = color;
        this.ram = ram;
        this.memoryDisc = memoryDisc;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getTypeDisc() {
        return typeDisc;
    }

    public String getColor() {
        return color;
    }

    public int getMemoryDisc() {
        return memoryDisc;
    }

    public int getRam() {
        return ram;
    }

    public String getOs() {
        return os;
    }

    public Object testGetField(String name){
        try {
            Field f = this.getClass().getDeclaredField(name);
            return f.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }

    }
    public Object getFieldByName(String name){
        try {
            Field field = this.getClass().getDeclaredField(name);
            return field.get(this);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Laptop{" +
               "os='" + os + '\'' +
               ", typeDisc='" + typeDisc + '\'' +
               ", color='" + color + '\'' +
               ", ram=" + ram +
               ", memoryDisc=" + memoryDisc +
               ", price=" + price +
               '}';
    }
}