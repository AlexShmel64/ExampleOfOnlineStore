package task01.data.data_source.cart;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.model.CartItem;
import task01.data.model.Product;

import java.util.ArrayList;

public class MockCartDataSourceImpl extends CartDataSource{
    private ArrayList<CartItem> cart = new ArrayList<>();
    @Override
    public void addToCart(Product product, int count) {
        cart.add(new CartItem(product, count));
    }

    @Override
    public boolean removeFromCart(Product product) {
        int numOfRemovePosition = -1;
        for(int i=0; i<cart.size(); i++) {
            if(cart.get(i).product.id.equals(product.id)) {
                numOfRemovePosition = i;
            }
        }
        if(numOfRemovePosition >= 0 && numOfRemovePosition < cart.size()){
            cart.remove(numOfRemovePosition);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void removeAllCart() {
        cart.removeAll(cart);
    }

    @Override
    public ArrayList<CartItem> getCart() {
        return cart;
    }
}
