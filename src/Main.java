import CollectionsStreamsMultiThreading.*;
import ObjectOrientedProgramming.Encapsulation.Inventory;
import ObjectOrientedProgramming.Encapsulation.Item;
import ObjectOrientedProgramming.InheritanceAndPolymorphism.ComputerParts;
import ObjectOrientedProgramming.InheritanceAndPolymorphism.Fruit;

import java.util.List;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        JavaStreams<String> js = new JavaStreams<>();
        js.addElement("Hello", "World", "Java", "Streams", "Hello","Saif");
//        System.out.println(js.useMap());
        List<String> filteredList = js.getSomeList();
        js.usingGroupByFirstLetter();

        System.out.println(String.join(" | ", filteredList));
        MultiThreading mt = new MultiThreading("Thread-1");
        mt.usingExecutorService();


    }


}