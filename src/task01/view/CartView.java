package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.data.model.CartItem;
import task01.data.service.ShopService;

import java.util.ArrayList;

public class CartView extends AppView {
    public CartView(ShopService shopService, ArrayList<AppView> children) {
        super("Корзина", children);
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        ArrayList<CartItem> cart = shopService.getCart();
        if(cart.size() == 0){
            System.out.println("Корзина пуста");
        }
        for(CartItem cartItem : cart){
            System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
        }
        System.out.println();
    }
}
