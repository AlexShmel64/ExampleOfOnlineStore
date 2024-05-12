package task01.data.model;
//Тема 1. Итоговое задание - виртуальный-магазин

import java.util.ArrayList;

public class Order {
    final String name;
    final String phone;
    final String address;
    final String paymentType;
    final String deliveryTime;
    final ArrayList<CartItem> cart;

    public Order(String name, String phone, String address, String paymentType, String deliveryTime, ArrayList<CartItem> cart) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.paymentType = paymentType;
        this.deliveryTime = deliveryTime;
        this.cart = cart;
    }
    public Order getOrder(){
        return this;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getAddress(){
        return this.address;
    }
    public String getPaymentType(){
        return this.paymentType;
    }
    public String getDeliveryTime(){
        return this.deliveryTime;
    }
    public ArrayList<CartItem> getCart(){
        return this.cart;
    }
}
