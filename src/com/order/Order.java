package com.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order {
    static List<Dish> dishList = new ArrayList<>();
    static List<Dish> personList = new ArrayList<>();

    public static void main(String[] args) {
        initDish();

        while (true) {
            showMenu();
            Scanner s = new Scanner(System.in);
            int menuChoice = s.nextInt();

            switch (menuChoice) {
                case 1:
                    showDishMenu();
                    while (true) {
                        int dishChoice = s.nextInt();
                        if (dishChoice == 0) {
                            break;
                        }
                        addDish(dishChoice);
                    }
                    break;
                case 2:
                    while (true) {
                        showOrderMenu();
                        int choice = s.nextInt();
                        if (choice == 0) {
                            break;
                        } else {
                            changeDishNum(choice);
                        }
                    }
                    break;
                case 3:
                    buy();
                    return;
            }
        }
    }

    private static void buy() {
        System.out.println("亲，您的订单如下：");
        for (int i = 0; i < personList.size(); i++) {
            Dish dish = personList.get(i);
            System.out.println(dish.id + "\t\t" +
                    dish.name + "\t\t" +
                    dish.num + "\t\t合计" +
                    dish.price * dish.num);
        }
        System.out.println("共消费¥" + caculateTotalCost());
        System.out.println("祝您用餐愉快！");
    }

    private static double caculateTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < personList.size(); i++) {
            totalCost += personList.get(i).num * personList.get(i).price;
        }
        return totalCost;
    }

    private static void changeDishNum(int changeNumChoice) {
        Dish dish = new Dish();
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).id == changeNumChoice) {
                dish = personList.get(i);
                System.out.println("您已点" + personList.get(i).name + personList.get(i).num + "份");
                System.out.println("请输入1或2调整数量，输入0确认");
                break;
            }
        }
        Scanner s = new Scanner(System.in);
        while (true) {
            int c = s.nextInt();
            if (c == 0) {
                break;
            }
            switch (c) {
                case 1:
                    dish.num--;
                    break;
                case 2:
                    dish.num++;
                    break;
            }
            System.out.println(dish.name + "的数量调整为" + dish.num);
        }
    }

    private static void showOrderMenu() {
        System.out.println("亲，您已经点了：");
        for (int i = 0; i < personList.size(); i++) {
            Dish dish = personList.get(i);
            System.out.println(dish.id + "\t\t" +
                    dish.name + "\t\t" +
                    dish.num + "\t\t合计" +
                    dish.price * dish.num);
        }
        System.out.println("输入对应菜品号调整数量,输入0返回主菜单");
    }

    private static void addDish(int dishChoice) {
        boolean repeatOrder = false;
        for (int i = 0; i < personList.size(); i++) {
            if (personList.get(i).id == dishList.get(dishChoice - 1).id) {
                personList.get(i).num++;
                repeatOrder = true;
                break;
            }
        }
        if (repeatOrder == false) {
            personList.add(dishList.get(dishChoice - 1));
            dishList.get(dishChoice - 1).num++;
        }
        System.out.println(dishList.get(dishChoice - 1).name + "已加入清单");
    }

    private static void showMenu() {
        System.out.println("----主菜单----");
        System.out.println("1" + "\t\t" + "点餐");
        System.out.println("2" + "\t\t" + "查看已点菜单");
        System.out.println("3" + "\t\t" + "下单");
    }

    private static void showDishMenu() {
        System.out.println("亲，请您点菜 ~");
        System.out.println("菜品号\t菜品\t\t\t价格");
        for (int i = 0; i < dishList.size(); i++) {
            Dish d = dishList.get(i);
            System.out.println(d.id + "\t\t" + d.name + "\t\t" + d.price);
        }
        System.out.println("输入0回到主菜单");
    }

    private static void initDish() {
        System.out.println("欢迎光临！");
        dishList.add(new Dish(1, "炖王八", 89.00d, 0));
        dishList.add(new Dish(2, "家常凉菜", 45.00d, 0));
        dishList.add(new Dish(3, "油焖大虾", 120.00d, 0));
        dishList.add(new Dish(4, "米饭\t", 6.00d, 0));
        dishList.add(new Dish(5, "水果拼盘", 25.00d, 0));
        dishList.add(new Dish(6, "鱼香肉丝", 55.00d, 0));
    }
}
