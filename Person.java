import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, LocalDate deathDate, Person mother, Person father) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Имя: " + name + 
               ", Дата рождения: " + birthDate + 
               ", Дата смерти: " + (deathDate != null ? deathDate : "Живой") + 
               ", Мать: " + (mother != null ? mother.getName() : "Нет данных") + 
               ", Отец: " + (father != null ? father.getName() : "Нет данных");
    }
}
