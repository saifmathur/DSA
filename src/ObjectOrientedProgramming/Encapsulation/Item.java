package ObjectOrientedProgramming.Encapsulation;

public class Item {
    private String name;
    private int quantity;


    //constructor
    public Item(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }


    //Getters and Setters and allow us to access and modify private fields
    //this is encapsulation
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }



    //This is polymorphism,
    //what type of polymorphism is this? Runtime or compile time?
    //This is an example of method overriding, which is a form of runtime polymorphism.
    @Override
    public String toString() {
        return "Item Name: " + name + ", Quantity: " + quantity;
    }
}
