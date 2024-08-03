package service;

import java.util.ArrayList;
import java.util.List;

import model.FamilyTree;
import model.Person;

public class Research {
    private FamilyTree familyTree;

    public Research(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void printChildren(String parentName) {
        for (Person person : familyTree.getPeople()) {
            if (person.getName().equals(parentName)) {
                List<Person> children = familyTree.getChildren(person);
                System.out.println("Дети " + parentName + ":");
                for (Person child : children) {
                    System.out.println(child.getName());
                }
                return;
            }
        }
        System.out.println("Родитель не найден.");
    }

    public List<Person> getDescendants(Person ancestor) {
        List<Person> descendants = new ArrayList<>();
        List<Person> children = familyTree.getChildren(ancestor);
        for (Person child : children) {
            descendants.add(child);
            descendants.addAll(getDescendants(child));
        }
        return descendants;
    }
}
