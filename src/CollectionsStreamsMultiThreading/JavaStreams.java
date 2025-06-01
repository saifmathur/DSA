package CollectionsStreamsMultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreams<T> {

    private List<T> someList = new ArrayList<>();


    public JavaStreams() {
        // Default constructor
    }

    public void addElement(T element) {
        someList.add(element);
    }

    public void addElement(T...elements) {
        someList.addAll(Arrays.asList(elements));
    }

    public List<T> useFilter(T search){
        return someList.stream().filter(f->f.equals(search)).toList();
    }

    public List<T> useFindOne(T search) {
        return someList.stream().filter(f -> f.equals(search)).findFirst()
                .map(List::of)
                .orElseGet(ArrayList::new);
    }


    public List<T> useMap(){
        return someList.stream().map(e-> {
            return (T) (e.toString().toUpperCase());
        }).toList();
    }

    public List<T> getSomeList() {
        return someList;
    }

    public void usingGroup(){
        System.out.println(someList.stream().collect(Collectors.groupingBy(el->el.getClass().getSimpleName())));
    }

    public void usingGroupByFirstLetter(){
        if(someList.stream().allMatch(e-> e instanceof String)) {
            System.out.println(someList.stream().collect(Collectors.groupingBy(name->name.toString().charAt(0))));
        }
    }

}
