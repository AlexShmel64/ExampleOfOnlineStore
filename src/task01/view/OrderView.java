package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.common.PaymentType;
import task01.data.service.ShopService;

import java.util.ArrayList;
import java.util.Scanner;

import static task01.common.PaymentType.bankCard;
import static task01.common.PaymentType.cash;

public class OrderView extends AppView {
    public OrderView(ShopService shopService) {
        super("Оформление заказа", new ArrayList<>());
        this.shopService = shopService;
    }
    final ShopService shopService;

    @Override
    public void action() {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите свое имя");
        String name = in.nextLine();
        System.out.println("Введите свой телефон");
        String phone = in.nextLine();
        System.out.println("Введите адрес доставки");
        String address = in.nextLine();
        PaymentType paymentType = cash;
        System.out.println("Выберите способ платежа (1 - банковской картойб 2 - наличными");
        String pType = in.nextLine();
        if(pType.equals("1")){
            paymentType = bankCard;
        }
        System.out.println("Укажите время доставки");
        String deliveryTime = in.nextLine();

        shopService.createOrder(name, phone, address, String.valueOf(paymentType), deliveryTime);
        System.out.println("Заказ оформлен");
    }
}
