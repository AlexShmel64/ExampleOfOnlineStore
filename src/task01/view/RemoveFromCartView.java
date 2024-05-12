package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveFromCartView extends AppView {
    public RemoveFromCartView(ShopService shopService) {
        super("Удалить товар", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите id продукта");
        String productId = in.nextLine();
        if(productId == null) return;
        final boolean res = shopService.removeFromCart(productId);
        if(res){
            System.out.println("Товар удален");
        }else{
            System.out.println("Не удалось удалить товар");
        }
    }
}
