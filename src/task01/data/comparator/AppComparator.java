package task01.data.comparator;
//Тема 1. Итоговое задание - виртуальный-магазин

import java.util.Comparator;

public class AppComparator<T> {
    public Comparator<T> comparator;
    public String name;

    public AppComparator(Comparator<T> comparator, String name) {
        this.comparator = comparator;
        this.name = name;
    }
}
