package task01.data.model;
//Тема 1. Итоговое задание - виртуальный-магазин

public class CartItem {
    public final Product product;
    public final int count;

    public CartItem(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
