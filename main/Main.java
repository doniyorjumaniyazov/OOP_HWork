package main;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import model.FamilyTree;
import model.Person;
import service.FileHandler;

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

        // Вывод информации о всех людях
        System.out.println("Список всех людей в генеалогическом древе:");
        familyTree.printFamilyTree();

        // Получение и вывод всех детей выбранного человека
        System.out.println("\nДети Дониёра:");
        List<Person> childrenOfDoniyor = familyTree.getChildren(doniyor);
        for (Person child : childrenOfDoniyor) {
            System.out.println(child.getName());
        }

        // Вывод всей информации о человеке
        System.out.println("\nИнформация о Рустаме:");
        System.out.println(rustam);

        System.out.println("\nИнформация о Севаре:");
        System.out.println(sevora);

        // Сортировка по имени
        familyTree.sortByName();
        System.out.println("\nОтсортировано по имени:");
        familyTree.printFamilyTree();

        // Сортировка по дате рождения
        familyTree.sortByBirthDate();
        System.out.println("\nОтсортировано по дате рождения:");
        familyTree.printFamilyTree();

        // Сохранение в файл и загрузка из файла
        FileHandler fileHandler = new FileHandler();

        try {
            // Сохранение в файл
            fileHandler.saveToFile(familyTree, "family_tree.ser");
            System.out.println("\nДрево сохранено в файл.");

            // Очистка текущего древа и загрузка из файла
            familyTree = fileHandler.loadFromFile("family_tree.ser");
            System.out.println("\nДрево загружено из файла.");
            familyTree.printFamilyTree();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
