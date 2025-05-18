package ObjectOrientedProgramming.InheritanceAndPolymorphism;

import ObjectOrientedProgramming.Abstraction.Item2;

public class ComputerParts extends Item2 {

    private String type;
    private String name;
    private int quantity;

    public ComputerParts(String type, String name, int quantity) {
        super(name, quantity);
        this.type = type;
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Computer Part Type: " + type);
        System.out.println("Computer Part Name: " + name);
        System.out.println("Computer Part Quantity: " + quantity);
    }
}
