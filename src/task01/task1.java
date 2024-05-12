package task01;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.common.PageLoop;
import task01.data.comparator.AppComparator;
import task01.data.comparator.PriceComparator;
import task01.data.data_source.cart.CartDataSource;
import task01.data.data_source.cart.MockCartDataSourceImpl;
import task01.data.data_source.catalog.CatalogDataSource;
import task01.data.data_source.catalog.MockCatalogDataSourceImpl;
import task01.data.data_source.order.MockOrderDataSourceImpl;
import task01.data.data_source.order.OrderDataSource;
import task01.data.model.Product;
import task01.data.service.ShopService;
import task01.view.*;

import java.util.ArrayList;

public class task1 {
    public static void main(String[] args) {
        CartDataSource cartDataSource = new MockCartDataSourceImpl();
        CatalogDataSource catalogDataSource = new MockCatalogDataSourceImpl();
        OrderDataSource orderDataSource = new MockOrderDataSourceImpl();
        ShopService shopService = new ShopService(catalogDataSource, cartDataSource, orderDataSource);

        AppView addToCartView = new AddToCartView(shopService);

        ArrayList<AppView> catalogChildren = new ArrayList<>();
        catalogChildren.add(addToCartView);

        ArrayList<AppComparator<Product>> catalogComparators = new ArrayList<>();
        catalogComparators.add(new AppComparator<>(new PriceComparator(true), "по возрастанию"));
        catalogComparators.add(new AppComparator<>(new PriceComparator(false), "по убыванию"));
        AppView catalogView = new CatalogView(shopService, catalogChildren, catalogComparators);

        ArrayList<AppView> cartViewChildren = new ArrayList<>();
        AppView removeFromCartView = new RemoveFromCartView(shopService);
        cartViewChildren.add(removeFromCartView);
        AppView removeAllCartView = new RemoveAllCartView(shopService);
        cartViewChildren.add(removeAllCartView);
        AppView cartView = new CartView(shopService, cartViewChildren);
        AppView orderView = new OrderView(shopService);

        AppView displayOrderView = new DisplayOrderView(shopService);

        ArrayList<AppView> mainChildren = new ArrayList<>();
        mainChildren.add(catalogView);
        mainChildren.add(cartView);
        mainChildren.add(orderView);
        mainChildren.add(displayOrderView);
        AppView mainView = new MainView(mainChildren);

        new PageLoop(mainView).run();
    }
}
