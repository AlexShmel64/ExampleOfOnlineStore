package task01.common;
//Тема 1. Итоговое задание - виртуальный-магазин

import task01.data.comparator.AppComparator;

import java.util.Scanner;

public class PageLoop {
    final AppView view;
    int getChildrenSize(){
        return view.children.size();
    }
    int getOptionalSize(){
        int optionalSize = 0;
        if(view.hasNextPage) optionalSize++;
        optionalSize += view.availableComparator.size();
        return optionalSize;
    }
    public PageLoop(AppView view) {
        this.view = view;
    }
    public void run(){
        while (true){
            view.action();
            displayChildren();
            final int fullSize = getChildrenSize() + getOptionalSize() + 1;
            Scanner in = new Scanner(System.in);
            int value = in.nextInt();
            if (value < 0 || value > fullSize) {
                System.out.println("Неверное значение страницы");
            } else if (value == fullSize) {
                view.nowPage = 0;
                break;
            } else if(value < getChildrenSize() + 1){
                AppView selectedView = view.children.get(value - 1);
                new PageLoop(selectedView).run();
            }else{
                if(value == getChildrenSize() + 1 && view.hasNextPage) {
                    view.nowPage++;
                    new PageLoop(view).run();
                }else{
                    view.nowPage = 0;
                    int comparatorIndex = value - getChildrenSize() - 1 - (view.hasNextPage ? 1 : 0);
                    view.selectedComparator = view.availableComparator.get(comparatorIndex);
                    new PageLoop(view).run();
                }
            }
        }
    }
    void displayChildren(){
        int currentIndex = 1;
        System.out.println(view.title);
        System.out.println("Выберите вариант (от 1 до " + (getChildrenSize() + getOptionalSize() + 1) + ")");
        for(int i=0; i<getChildrenSize(); i++){
            AppView _view = view.children.get(i);
            System.out.println(currentIndex + " - " + _view.title);
            currentIndex++;
        }
        if(view.hasNextPage){
            System.out.println(currentIndex + " - " + "Следующая страница");
            currentIndex++;
        }
        for(int i=0; i<view.availableComparator.size(); i++){
            System.out.println(currentIndex + " - " + view.availableComparator.get(i).name);
            currentIndex++;
        }
        System.out.println((getChildrenSize() + getOptionalSize() + 1) + " - Назад");
    }
}
