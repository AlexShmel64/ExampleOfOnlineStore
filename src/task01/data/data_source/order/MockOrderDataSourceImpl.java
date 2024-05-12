package task01.data.data_source.order;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.model.Order;

public class MockOrderDataSourceImpl extends OrderDataSource{
    private Order order;
    @Override
    public void createOrder(Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return order;
    }
}
