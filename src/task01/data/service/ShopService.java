package task01.data.service;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.data_source.cart.CartDataSource;
import task01.data.data_source.catalog.CatalogDataSource;
import task01.data.data_source.order.OrderDataSource;
import task01.data.model.CartItem;
import task01.data.model.Order;
import task01.data.model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public class ShopService {
    final CatalogDataSource catalogDataSource;
    final CartDataSource cartDataSource;
    final OrderDataSource orderDataSource;

    public ShopService(CatalogDataSource catalogDataSource, CartDataSource cartDataSource, OrderDataSource orderDataSource) {
        this.catalogDataSource = catalogDataSource;
        this.cartDataSource = cartDataSource;
        this.orderDataSource = orderDataSource;
    }
    public ArrayList<Product> getCatalog(int page, int limit){
        return catalogDataSource.getCatalog(page, limit);
    }
    public ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator){
        return catalogDataSource.getCatalog(page, limit, comparator);
    }
    public boolean addToCart(String productId, int count){
        Product product = catalogDataSource.productById(productId);
        if(product != null){
            cartDataSource.addToCart(product, count);
            return true;
        }
        return false;
    }
    public boolean removeFromCart(String productId){
        Product product = catalogDataSource.productById(productId);
        if(product != null){
            return cartDataSource.removeFromCart(product);
        }
        return false;
    }
    public void removeAllCart(){
        cartDataSource.removeAllCart();
    }
    public ArrayList<CartItem> getCart(){
        return cartDataSource.getCart();
    }
    public void createOrder(String name, String phone, String address, String paymentType, String deliveryTime){
        ArrayList<CartItem> cart = getCart();
        Order newOrder = new Order(name, phone, address, paymentType, deliveryTime, cart);
        orderDataSource.createOrder(newOrder);
    }
    public Order getOrder(){
        return orderDataSource.getOrder();
    }
}
