package ObjectOrientedProgramming.Abstraction;


//abstraction is the process of hiding the implementation details and showing only the essential features of the object.
public abstract class Item2 {

    private String name;
    private int quantity;

    public Item2(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public abstract void displayInfo(); //abstract method, no body
    //abstract methods are declared without an implementation
    //subclasses must provide an implementation for this method
    //abstract classes can have both abstract and non-abstract methods
    //abstract classes cannot be instantiated
    //abstract classes can have constructors
    //abstract classes can have fields
    //abstract classes can have static methods



    //there is another way to implement abstraction in java, which is through interfaces
}
