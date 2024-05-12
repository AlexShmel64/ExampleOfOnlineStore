package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.data.service.ShopService;

import java.util.ArrayList;

public class RemoveAllCartView extends AppView {
    public RemoveAllCartView(ShopService shopService) {
        super("Очистить корзину", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        shopService.removeAllCart();
        System.out.println("Корзина очищена");
    }
}
