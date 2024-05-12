package task01.data.data_source.catalog;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.model.Product;

import java.util.ArrayList;
import java.util.Comparator;

public abstract class CatalogDataSource {
    public abstract ArrayList<Product> getCatalog(int page, int limit, Comparator<Product> comparator);
    public abstract ArrayList<Product> getCatalog(int page, int limit);
    public abstract Product productById(String id);
}
