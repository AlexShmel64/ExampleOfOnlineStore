package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.data.model.CartItem;
import task01.data.service.ShopService;

import java.util.ArrayList;

public class DisplayOrderView extends AppView {
    public DisplayOrderView(ShopService shopService) {
        super("Просмотр заказа", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        if(shopService.getOrder() != null) {
            System.out.println("Имя: " + shopService.getOrder().getName());
            System.out.println("Телефон: " + shopService.getOrder().getPhone());
            System.out.println("Адрес доставки: " + shopService.getOrder().getAddress());
            System.out.println("Способ оплаты: " + shopService.getOrder().getPaymentType());
            System.out.println("Время доставки: " + shopService.getOrder().getDeliveryTime());
            System.out.println("Перечень товаров");
            double price = 0;
            for (CartItem cartItem : shopService.getCart()) {
                System.out.println(cartItem.product.id + " " + cartItem.product.title + " " + cartItem.count);
                price = price + cartItem.count * cartItem.product.price;
            }
            System.out.println();
            System.out.println("Сумма заказа: " + price);
        } else{
            System.out.println("Заказ не оформлен");
        }
    }
}
