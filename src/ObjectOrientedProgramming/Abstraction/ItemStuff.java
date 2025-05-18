package ObjectOrientedProgramming.Abstraction;

public interface ItemStuff {

    //interface is a reference type in java, similar to class
    //a special type of class that can only contain abstract methods and final variables
    //interfaces cannot be instantiated
    //interfaces can have static methods
    //interfaces can have default methods
    //interfaces can have private methods
    //interfaces can extend multiple interfaces
    //interfaces can be implemented by classes
    //interfaces are used to achieve abstraction and multiple inheritance in java

    void displayInfo(); //abstract method, no body
    String getName(); //abstract method, no body
    int getQuantity();
}
