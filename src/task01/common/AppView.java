package task01.common;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.comparator.AppComparator;
import task01.data.model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class AppView {
    public final String title;
    public final ArrayList<AppView> children;
    public int nowPage = 0;
    public boolean hasNextPage = false;
    public final ArrayList<AppComparator<Product>> availableComparator = new ArrayList<>();
    public AppComparator<Product> selectedComparator;

    public AppView(String title, ArrayList<AppView> children) {
        this.title = title;
        this.children = children;
    }

    public void action(){
    }
}
