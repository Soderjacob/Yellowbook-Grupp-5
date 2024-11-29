import java.util.ArrayList;
import java.util.Scanner;

public class AdminRights {

    private ArrayList<Person> contacts;

    public AdminRights(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public AdminRights() {

    }

    public void addContact(Person person) {
        this.contacts.add(person);
    }

    public void editContact(int index, Person newPerson) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, newPerson);
        } else {
            System.out.println("Ogiltigt index!");
        }
    }

    public void removeContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        } else {
            System.out.println("Ogiltigt index!");
        }
    }

    public void displayContacts() {
        for (Person person : contacts) {
            System.out.println(person.toString());
        }
    }

    public void addNewPerson() {
        //ArrayList<Person> examplePersons = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        /*

        System.out.println("Hur många kontakter vill du lägga till?");
        int numberOfContacts = scanner.nextInt();
        scanner.nextLine(); // Konsumera den återstående nya raden

         */

        //for (int i = 0; i < numberOfContacts; i++) {
            System.out.println("Ange förnamn:");
            String firstName = scanner.nextLine();

            System.out.println("Ange efternamn:");
            String lastName = scanner.nextLine();

            System.out.println("Ange ålder:");
            int age = scanner.nextInt();
            scanner.nextLine(); // Konsumera den återstående nya raden

            System.out.println("Ange telefonnummer (kommaseparerade om flera):");
            String[] phoneNumbers = scanner.nextLine().split(",");

            System.out.println("Ange adress (gata):");
            String street = scanner.nextLine();

            System.out.println("Ange stad:");
            String city = scanner.nextLine();

            System.out.println("Ange postnummer:");
            String postalCode = scanner.nextLine();

            Address address = new Address(street, city, postalCode);
            Person person = new Person(firstName, lastName, age, phoneNumbers, address);
            contacts.add(person);
        //}

        //return examplePersons;
    }

    public void adminFunction() {

        addNewPerson();
        return;

        // displayPersons(admin);

        // Redigera en befintlig kontakt
        // Person editedPerson = new Person("Tratt", "Trattson", 50, new String[] {"0707654321"}, newAddress);
        // editContact(0, editedPerson);

        // Ta bort en kontakt
        // removeContact(1);

        /* Visa uppdaterade kontakter
        displayPersons(admin);

         */
    }

    private static void displayPersons(AdminRights admin) {
        // Visa alla kontakter
        admin.displayContacts();
    }

}