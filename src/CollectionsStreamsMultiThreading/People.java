package CollectionsStreamsMultiThreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class People {

    private final List<Person> people = new ArrayList<>();

    public People() {
        createPeople();
    }

    public void createPeople() {
        people.add(new Person("Alice", 30, 50000));
        people.add(new Person("Bob", 25, 60000));
        people.add(new Person("Charlie", 35, 70000));
    }

    public void displayPeople() {
        people.forEach(p-> System.out.println("Name: " + p.getName() + ", Age: " + p.getAge() + ", Salary: " + p.getSalary()));
    }

    public void sortPeopleByAge() {
        Collections.sort(people);
        displayPeople();
    }


    public void sortPeopleByNameUsingComparator() {
        people.sort((p1, p2) -> p1.getName().compareTo(p2.getName()));
        displayPeople();
    }

    public void sortPeopleBySalaryUsingComparator() {
        people.sort((p1, p2) -> Integer.compare(p1.getSalary(), p2.getSalary()));
        displayPeople();
    }

    public Person getPersonWithHighestSalary(){
        return people.stream().max((p1,p2)->Integer.compare(p1.getSalary(), p2.getSalary())).orElse(null);
    }

    public void sortByMaxSalary(){
        people.sort(Comparator.comparing(Person::getSalary).reversed());
        displayPeople();
    }

}
