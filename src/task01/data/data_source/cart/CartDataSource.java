package task01.data.data_source.cart;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.model.CartItem;
import task01.data.model.Product;

import java.util.ArrayList;

public abstract class CartDataSource {
    public abstract void addToCart(Product product, int count);
    public abstract boolean removeFromCart(Product product);
    public abstract void removeAllCart();
    public abstract ArrayList<CartItem> getCart();
}
