package task01.data.data_source.order;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.model.Order;

public abstract class OrderDataSource {
    public abstract void createOrder(Order order);
    public abstract Order getOrder();
}