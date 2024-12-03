import java.util.ArrayList;
import java.util.Scanner;

public class AdminRights {

    private ArrayList<Person> contacts;

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public AdminRights(ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public AdminRights() {

    }

    public void addContact(Person person) {
        this.contacts.add(person);
    }


    // *************  Edit contact  *****************
    // If the user presses the Enter key without typing anything, the program keeps the previous value.

    public void editContact(int index, Person newPerson) {
        Scanner scanner = new Scanner(System.in);
        if (index >= 0 && index < contacts.size()) {

            System.out.print("Enter first name ( " + newPerson.firstName + " ) :");
            String firstName = newPerson.firstName;
            String firstName1 = scanner.nextLine();
            if (!firstName1.isEmpty()) {
                firstName = firstName1;
            }

            System.out.print("Enter last name ( " + newPerson.lastName + " ) :");
            String lastName = newPerson.lastName;
            String lastName1 = scanner.nextLine();
            if (!lastName1.isEmpty()) {
                lastName = lastName1;
            }

            System.out.print("Enter age ( " + newPerson.age + " ) :");
            int age = newPerson.age;
            String age1 = scanner.nextLine();
            if (!age1.isEmpty()) {
                age = Integer.parseInt(age1);
            }

            System.out.print("Enter phone number : ");
            String[] phoneNumbers = newPerson.phoneNumbers;
            int i = 0;
            for (String num : phoneNumbers) {
                System.out.print(" ( " + num + " ) : ");
                String Num1 = scanner.nextLine();
                if (!Num1.isEmpty()) {
                    newPerson.phoneNumbers[i] = Num1;
                }
                i++;
            }

            System.out.print("Enter adress (Street) ( " + newPerson.address.StreetName + " ) :");
            String street = newPerson.address.StreetName;
            String street1 = scanner.nextLine();
            if (!street1.isEmpty()) {
                street = street1;
            }

            System.out.print("Enter city ( " + newPerson.address.city + " ) :");
            String city = newPerson.address.city;
            String city1 = scanner.nextLine();
            if (!city1.isEmpty()) {
                city = city1;
            }

            System.out.print("Enter postal code ( " + newPerson.address.postalCode + " ) :");
            String postalCode = newPerson.address.postalCode;
            String postalCode1 = scanner.nextLine();
            if (!postalCode1.isEmpty()) {
                postalCode = postalCode1;
            }

            System.out.print("Enter door code ( " + newPerson.address.doorCode + " ) :");
            String doorCode = newPerson.address.doorCode;
            String doorCode1 = scanner.nextLine();
            if (!doorCode1.isEmpty()) {
                doorCode = doorCode1;
            }

            Address address = new Address(street, city, postalCode, doorCode);
            Person person = new Person(firstName, lastName, age, phoneNumbers, address);

            contacts.set(index, person);
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

        System.out.println("Ange portkod:");
        String doorCode = scanner.nextLine();

        Address address = new Address(street, city, postalCode, doorCode);
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