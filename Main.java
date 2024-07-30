import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        // Создание людей
        Person rustam = new Person("Рустам", LocalDate.of(1962, 4, 4), null, null, null);
        Person boyjon = new Person("Бойжон", LocalDate.of(1940, 1, 1), null, null, null);
        Person mukaddas = new Person("Мукаддас", LocalDate.of(1962, 5, 5), null, boyjon, null);
        Person doniyor = new Person("Дониёр", LocalDate.of(1987, 11, 8), null, mukaddas, rustam);
        Person sevora = new Person("Севара", LocalDate.of(1991, 2, 2), null, null, null);
        Person samiy = new Person("Самий", LocalDate.of(2015, 12, 3), null, sevora, doniyor);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(rustam);
        familyTree.addPerson(boyjon);
        familyTree.addPerson(mukaddas);
        familyTree.addPerson(doniyor);
        familyTree.addPerson(sevora);
        familyTree.addPerson(samiy);

        // Вариант 1: Получение и вывод всех детей выбранного человека
        System.out.println("Вариант 1: Дети Дониёра");
        List<Person> childrenOfDoniyor = familyTree.getChildren(doniyor);
        for (Person child : childrenOfDoniyor) {
            System.out.println(child.getName());
        }

        // Вариант 2: Вывод всей информации о человеке
        System.out.println("\nВариант 2: Информация о Рустаме");
        System.out.println(rustam);

        System.out.println("\nВариант 2: Информация о Севара");
        System.out.println(sevora);

        // Сохранение в файл и загрузка из файла
        FileHandler fileHandler = new FileHandler(familyTree);

        try {
            // Сохранение в файл
            fileHandler.saveToFile("family_tree.ser");
            System.out.println("\nДрево сохранено в файл.");

            // Очистка текущего древа и загрузка из файла
            familyTree = new FamilyTree();
            fileHandler = new FileHandler(familyTree);
            fileHandler.loadFromFile("family_tree.ser");
            System.out.println("\nДрево загружено из файла.");
            familyTree.printFamilyTree();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
