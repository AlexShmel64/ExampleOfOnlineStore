package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;
import task01.common.Paginable;
import task01.data.comparator.AppComparator;
import task01.data.comparator.PriceComparator;
import task01.data.model.Product;
import task01.data.service.ShopService;

import java.util.ArrayList;

public class CatalogView extends AppView implements Paginable {
    public CatalogView(ShopService shopService, ArrayList<AppView> children, ArrayList<AppComparator<Product>> comparators) {
        super("Каталог", children);
        this.shopService = shopService;
        availableComparator.addAll(comparators);
        if(!availableComparator.isEmpty()){
            selectedComparator = availableComparator.get(0);
        }
    }
    final ShopService shopService;

    @Override
    public void action() {
        PriceComparator comparator = new PriceComparator();
        comparator.isAsc = false;
        ArrayList<Product> catalog = shopService.getCatalog(nowPage, pageLimit, selectedComparator.comparator);
        hasNextPage = catalog.size() == pageLimit;
        for(Product product : catalog){
            System.out.println(product.id + " " + product.title + " " + product.price);
        }
        System.out.println();
    }
}
