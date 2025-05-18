import ObjectOrientedProgramming.Encapsulation.Inventory;
import ObjectOrientedProgramming.Encapsulation.Item;
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

        // Display items in the inventory
        inventory.displayItems();


    }


}