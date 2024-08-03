package util;

import java.util.Iterator;
import java.util.List;

import model.Person;

public class TreeIterable implements Iterator<Person> {
    private List<Person> people;
    private int index;

    public TreeIterable(List<Person> people) {
        this.people = people;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < people.size();
    }

    @Override
    public Person next() {
        return people.get(index++);
    }
}
