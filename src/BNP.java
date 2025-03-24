import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
interface MyInterface {
    int add(int a, int b);
}

public class BNP {

    public void java8features() {
        List<String> names = Arrays.asList("saif", "mathur", "john", "doe");
        names.forEach(name -> System.out.println(name));


        //functional interface
        MyInterface sum = (a, b) -> a + b;
        System.out.println(sum.add(5, 10));

        //Predefined functional interface
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println(isEven.test(10));


        //streams api
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> doubledEvens = numbers.stream().filter(element -> element % 2 == 0).map(n -> n * 2).toList();
        System.out.println(doubledEvens);


    }

    public void collectionsFramework() {
//        The Java Collections Framework (JCF) provides a set of interfaces and classes to handle and manipulate groups of objects efficiently.
        List<String> list = new ArrayList<>(List.of("apple", "banana", "apple"));
        Set<String> set = new HashSet<>(List.of("apple", "banana", "apple"));
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(1, "new one");


        System.out.println(list);
        System.out.println(set);
        System.out.println(map);

        Engine engine = new Engine();
        Car car = new Car(engine);
        car.startCar();
    }


    static class Engine {
        void start() {
            System.out.println("Engine started");
        }
    }

    static class Car {
        Engine engine;

        Car(Engine engine) {
            this.engine = engine;
        }


        void startCar() {
            engine.start();
            System.out.println("car started");
        }
    }

    public void solid() {
        System.out.println();
        System.out.println("S: Single responsibility - > a class should only have one job" + "\nExample: Logger class is only used for java\n");
        System.out.println("O: Open/Closed Principal - > Code should be open for extension but closed for modification" + "\nExample: Use abstract classes and interfaces to allow extensions without modifying the code\n");
        System.out.println("L: Liskov Substitution Principal - > Subtypes should be interchangeable with their base types" + "\nExample: A Rectangle class should be usable where a shape is expected\n");
        System.out.println("I: Interface Segregation Principal - > A class should not be forced to implement the interfaces it does not use" + "\nExample: Split large interfaces into smaller specific ones\n");
        System.out.println("D: Dependency Inversion Principal - > Depends on abstractions, not on concrete classes" + "\nExample: Use interface type instead of concrete dependencies\n");

        System.out.println();
        Queue<String> q = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("saif");
    }


//    Open/Closed Principle (OCP)

    abstract static class Shape {
        abstract double area();
    }

    static class Circle extends Shape {

        double radius;

        Circle(double radius) {
            this.radius = radius;
        }


        @Override
        double area() {
            return Math.PI * Math.pow(radius, 2);
        }
    }

    static class Triangle extends Shape {

        double base, height;

        Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        @Override
        double area() {
            return 0.5 * (base * height);
        }
    }


    //    Liskov Substitution Principle (LSP)
    static class Bird {
        void fly() {
            System.out.println("Bird is flying");
        }
    }

    static class Penguin extends Bird {
        @Override
        void fly() {
            super.fly();
        }
    }

    //Interface Segregation Principle (ISP)
    interface Printer {
        void print();
    }

    interface Scanner {
        void scan();
    }

    static class SimplePrinter implements Printer, Scanner {

        @Override
        public void print() {
            System.out.println("Printing");
        }

        @Override
        public void scan() {
            System.out.println("also scans");
        }
    }


    //    Dependency Inversion Principle (DIP)
    interface Database {
        void save(String data);
    }

    static class MySQLDatabase implements Database {


        @Override
        public void save(String data) {
            System.out.println("saving " + data);
        }
    }
    static class Service{
        private Database database;

        Service(Database database){
            this.database = database;
        }

        void saveData(String data){
            database.save(data);
        }
    }



    //abstract class
    abstract static class Animal{
        abstract void makeSound();
    }


    class Parent{

        private int num = 200;
        public void staticMethod(){
            System.out.println("static 1");
        }
    }

    class Child extends Parent{

        @Override
        public void staticMethod(){
            System.out.println("static 2" + super.num);
        }
    }


    interface MyFunctionalInterface{
        void show();
    }

    static class FunctionalInterfaceClassImpl implements MyFunctionalInterface{

        @Override
        public void show() {
            System.out.println("functional interface");
        }
    }

}
