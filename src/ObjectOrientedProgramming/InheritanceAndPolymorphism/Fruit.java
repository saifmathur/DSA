package ObjectOrientedProgramming.InheritanceAndPolymorphism;

import ObjectOrientedProgramming.Abstraction.ItemStuff;
import ObjectOrientedProgramming.Encapsulation.Item;

public class Fruit implements ItemStuff {

    private int quantity;
    private String name;
    private String type;

    public Fruit(String type, String name, int quantity) {
        this.type = type;
    }

    @Override
    public void displayInfo() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }
}
