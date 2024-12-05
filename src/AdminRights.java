import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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


    // *************  Edit contact  *****************
    // If the user presses the Enter key without typing anything, the program keeps the previous value.

    public void editContact(int index, Person newPerson) throws IOException {

        String OldModified = String.valueOf(newPerson);
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
            String NewModified= String.valueOf(contacts.set(index, person));
            addToEditFile(OldModified,NewModified);
            addToFile();
        } else {
            System.out.println("Invalid input id!");
        }
    }

    // *************  Remove contact  *****************

    public void removeContact(int index) throws IOException {
        if (index >= 0 && index < contacts.size()) {

            addToRemovedFile(index);
            contacts.remove(index);
            addToFile();
        } else {
            System.out.println("Invalid input id!");
        }
    }


    public void displayContacts() throws IOException {
        int i=1;
        for (Person person : contacts) {
            System.out.println(
                    i + " -" + person.toString());
            i++;
        }
        addToFile();
    }

    public void addNewPerson() throws IOException {
        Scanner scanner = new Scanner(System.in);

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
        addToFile();

    }

    public void adminFunction() throws IOException {

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


    public void addToFile() throws IOException {
        FileWriter fr =new FileWriter("Contacts.txt");
        PrintWriter pr =new PrintWriter(fr,true);

        for (Person person : contacts) {
            pr.println(person.toString());
        }
        pr.close();
    }

    public void addToRemovedFile(int index) throws IOException {
        FileWriter fr =new FileWriter("RemovedContacts.txt",true);
        PrintWriter pr =new PrintWriter(fr,true);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        pr.println(" Deleted by admin on " + dtf.format(now) ) ;
        pr.println(contacts.get(index));
        pr.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------") ;
        pr.close();
    }

    public void addToEditFile(String oldPer,String newPer) throws IOException {
        FileWriter fr =new FileWriter("ModifiedContacts.txt",true);
        PrintWriter pr =new PrintWriter(fr,true);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        pr.println(" Modified by admin on " + dtf.format(now) ) ;
        pr.println("( Old profile ) " + oldPer);
        pr.println("( New profile ) " + newPer);
        pr.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------") ;
        pr.close();
    }


}