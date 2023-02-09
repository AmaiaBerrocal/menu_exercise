package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Menu menu = new Menu();

    public static boolean isExit = false;
    public static void main(String[] args) {
        menu.add(new ItemText("Uno"));
        menu.add(new ItemText("Dos"));
        menu.add(new ItemText("Tres"));
        menu.add(new ItemDelete("Delete"));
        menu.add(new ItemExit("Salir"));
        menu.add(new ItemAdd("Añadir"));

        do {
            menu.draw();
            menu.executeSelectedItem();
        } while (!isExit);
    }



}

interface Item {
    void execute();
}
class ItemText implements Item{
    String text;

    public ItemText(String text) {
        this.text = text;
    }

    @Override
    public void execute() {
        System.out.println(text.substring(3));
    }

    public String toString() {
        return text;
    }
}

class ItemExit implements Item{
    String text;

    public ItemExit(String text) {
        this.text = text;
    }

    @Override
    public void execute() {
        Main.isExit = true;
        System.out.println(text.substring(3));
    }

    public String toString() {
        return text;
    }
}

class ItemAdd implements Item{
    String text;

    public ItemAdd(String text) {
        this.text = text;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner( System.in );
        System.out.print("Introduce nuevo botón: ");
        String newButton = sc.nextLine();
        Main.menu.add(new ItemText(newButton));
        System.out.println(text.substring(3));
    }

    public String toString() {
        return text;
    }
}

class ItemDelete implements Item{
    String text;

    public ItemDelete(String text) {
        this.text = text;
    }

    @Override
    public void execute() {
        Scanner sc = new Scanner( System.in );
        System.out.print("Introduce opción a borrar: ");
        int buttonToDelete = sc.nextInt();
        Main.menu.remove(buttonToDelete-1);
        System.out.println(text.substring(3));
    }

    public String toString() {
        return text;
    }
}

class Menu {
    List<Item> menuList = new ArrayList<>();

    public void draw() {
        menuList.forEach(item -> {
            System.out.println((menuList.indexOf(item)+1) + " - " + item.toString());
        });
    }
    public void add(Item item) {
        menuList.add(item);
    }

    public void executeSelectedItem() {
        int n = catchReaderedNumber();
        menuList.get(n-1).execute();
    }

    public Integer catchReaderedNumber() {
        Scanner sc = new Scanner( System.in );
        System.out.print("Elija opción de menú: ");
        return sc.nextInt();
    }

    public void remove(int i) {
        menuList.remove(i);
    }
}