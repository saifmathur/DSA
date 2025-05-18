import ObjectOrientedProgramming.Encapsulation.Inventory;
import ObjectOrientedProgramming.Encapsulation.Item;
import ObjectOrientedProgramming.InheritanceAndPolymorphism.ComputerParts;
import ObjectOrientedProgramming.InheritanceAndPolymorphism.Fruit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        Inventory inventory = new Inventory();
        Item item2 = new Item("Banana", 20);
        Fruit fruit = new Fruit("Fuji", "Apple", 5);

        inventory.addItem(item2);
        inventory.addItem(fruit);



        // Add items to the inventory using compile time polymorphism
        inventory.addItem("Orange", 10);
        ComputerParts computerParts = new ComputerParts("CPU", "Intel i7", 1);


        computerParts.displayInfo();

        // Display items in the inventory
        inventory.displayItems();


    }


}