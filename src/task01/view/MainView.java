package task01.view;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.common.AppView;

import java.util.ArrayList;

public class MainView extends AppView {
    public MainView(ArrayList<AppView> children) {
        super("Магазин", children);
    }
}
