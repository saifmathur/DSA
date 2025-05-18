package ObjectOrientedProgramming.Encapsulation;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }


    //This will be an example of method overloading, which is a form of compile time polymorphism.
    public void addItem(String name, int quantity) {
        Item item = new Item(name, quantity);
        items.add(item);
    }


    public void displayItems() {
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }
}
