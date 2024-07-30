import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private List<Person> people;

    public FamilyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getChildren(Person parent) {
        List<Person> children = new ArrayList<>();
        for (Person person : people) {
            if (person.getMother() == parent || person.getFather() == parent) {
                children.add(person);
            }
        }
        return children;
    }

    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public void printFamilyTree() {
        for (Person person : people) {
            System.out.println(person);
            List<Person> children = getChildren(person);
            if (!children.isEmpty()) {
                System.out.println("Дети:");
                for (Person child : children) {
                    System.out.println(" - " + child.getName());
                }
            } else {
                System.out.println("Дети: Нет данных");
            }
            System.out.println();
        }
    }
}
