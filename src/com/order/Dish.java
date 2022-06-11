package com.order;

import java.util.List;

public class Dish {
    int id;
    String name;
    double price;
    int num;

    public Dish(int id, String name, double price, int num) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.num = num;
    }

    public Dish() {
    }
}
