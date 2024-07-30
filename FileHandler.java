import java.io.*;
import java.util.List;

public class FileHandler implements Serializable {
    private FamilyTree familyTree;

    public FileHandler(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public void saveToFile(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(familyTree.getPeople());
        }
    }

    @Override
    public void loadFromFile(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            @SuppressWarnings("unchecked")
            List<Person> people = (List<Person>) ois.readObject();
            familyTree.setPeople(people);
        }
    }
}
