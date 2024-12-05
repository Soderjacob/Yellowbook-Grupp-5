import java.io.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class YellowBook {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Admins login password
        Integer adminsPassword = 1337;
        //Example persons

        //ArrayList<Person> examplePersons = generateExamplePersons();

        ArrayList<Person> examplePersons = readFromFile();

        //create admin
        AdminRights admin = new AdminRights(examplePersons);
        Search search = new Search(examplePersons);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Yellow Book");

        Boolean userIsAdmin = false;
        boolean loginToAdminLoop = true;
        while (loginToAdminLoop) {

            //Admin login
            System.out.println("Do you want to login to admin? yes/no ");
            String loginToAdmin = scanner.next();
            if (Objects.equals(loginToAdmin, "yes")) {
                System.out.println("Password: ");
                Integer userAdminInput = scanner.nextInt();
                if (userAdminInput.equals(adminsPassword)) {
                    userIsAdmin = true;
                    loginToAdminLoop = false; //ends loginToAdmin loop if user types right password
                } else {
                    System.out.println("Wrong password.");
                }
            } else if (Objects.equals(loginToAdmin, "no")) { //ends loginToAdmin loop if user types no

                loginToAdminLoop = false;
            }
        }


        boolean showMenuLoop = true;
        while (showMenuLoop) {
            Integer userMenuChoice = null;
            //Visible menu
            System.out.println("----Menu----");
            System.out.println("1: Search");
            System.out.println("2: Quit");
            if (userIsAdmin) {
                System.out.println("3: Add person");
                System.out.println("4: Edit person");
                System.out.println("5: Remove person");
                System.out.println("6: Display all persons");
                System.out.println("7: Display removed persons");
                System.out.println("8: Display modified persons");
            }
            while (true) {
                try {
                    userMenuChoice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                }
            }

            switch (userMenuChoice) {
                case 1: {
                    searchDialog(scanner, search);

                    break;
                }
                case 2: {
                    System.out.println("Quitting program");

                    showMenuLoop = false;
                    break;
                }
                case 3: {
                    if (userIsAdmin) {
                        //function add person
                        admin.addNewPerson();
                        admin.displayContacts();


                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }
                case 4: {
                    if (userIsAdmin) {
                        //  function edit person
                        admin.displayContacts();


                        System.out.println("--------------------------------------------------------------------------");
                        if (admin.getContacts().isEmpty()) {
                            System.out.println("--------- There is no contacts to edit ---------");
                            break;
                        } else {
                            System.out.print("Input Person ID to edit his information ( 1 to " + admin.getContacts().size() + " ). Otherwise go to main menu :");
                        }

                        Integer personId = scanner.nextInt();

                        if (personId <= admin.getContacts().size()) {
                            System.out.println("--------------------------------------------------------------------------");
                            System.out.println(admin.getContacts().get(personId - 1));

                            admin.editContact(personId - 1, admin.getContacts().get(personId - 1));
                        }

                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }

                case 5: {
                    if (userIsAdmin) {
                        //  function Remove person

                        admin.displayContacts();

                        System.out.println("--------------------------------------------------------------------------");
                        if (admin.getContacts().isEmpty()) {
                            System.out.println("--------- There is no contacts to delete ---------");
                            break;
                        } else {
                            System.out.print("Input contact ID to delete ( 1 to " + admin.getContacts().size() + " ). Otherwise go to main menu :");
                        }
                        Integer personId = scanner.nextInt();
                        boolean yesNo = true;

                        do {

                            if (personId <= admin.getContacts().size()) {
                                System.out.println("--------------------------------------------------------------------------");
                                System.out.println(admin.getContacts().get(personId - 1));
                                System.out.println("Are you sure to delete ( Yes/No ) :");
                                String okToRemove = scanner.next();

                                if (okToRemove.toLowerCase().startsWith("y")) {

                                    admin.removeContact(personId - 1);

                                    yesNo = false;
                                } else if (okToRemove.toLowerCase().startsWith("n")) {
                                    yesNo = false;
                                }
                            }
                        } while (yesNo);

                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }

                case 6: {
                    if (userIsAdmin) {
                        //function display all
                        admin.addToFile();

                        admin.displayContacts();
                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }

                case 7: {
                    if (userIsAdmin) {
                        // function display Deleted Contacts
                        readDeletedFile();

                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }

                case 8: {
                    if (userIsAdmin) {
                        // function display Modified Contacts
                        readModifiedFile();

                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }


            }
        }
    }

    private static void searchDialog(Scanner scanner, Search search) {
        //SearchFunction
        boolean validInput = false;
        int searchMenuChoice = 0;

        while (!validInput){

            System.out.println("1. Search by first name");
            System.out.println("2. Search by last name");
            System.out.println("3. Search by street name");
            System.out.println("4. Free search");

            if (scanner.hasNextInt()) {
                searchMenuChoice = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please try a number again.");
                scanner.next();
            }
            scanner.nextLine();

            switch (searchMenuChoice) {
                case 1: {
                    List<Person> searchResult;
                    System.out.println("Enter first name: ");
                    String firstName = scanner.nextLine();
                    searchResult = search.searchByFirstName(firstName);

                    if (searchResult == null || searchResult.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        for (var Result : searchResult){
                            System.out.println(Result);
                            System.out.println();
                        }
                    }
                    break;
                }

                case 2: {
                    System.out.println("Enter last name : ");
                    String lastName = scanner.nextLine();
                    Person lastNameSearchResult = search.searchByLastName(lastName);
                    if (lastNameSearchResult == null) {
                        System.out.println("No results found.");
                    } else {
                        System.out.println(lastNameSearchResult.toString());
                    }
                    break;

                }

                case 3: {
                    System.out.println("Enter street name : ");
                    String streetName = scanner.nextLine();
                    List<Person> streetNameSearchResult = search.searchByStreetName(streetName);
                    if (streetNameSearchResult == null || streetNameSearchResult.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        for (var Result : streetNameSearchResult){
                            System.out.println(Result);
                            System.out.println();
                        }
                    }

                    break;
                }

                case 4: {
                    System.out.println("Free search: : ");
                    String query = scanner.nextLine();
                    List<Person> freeSearchResult = search.freeSearch(query);
                    if (freeSearchResult == null || freeSearchResult.isEmpty()) {
                        System.out.println("No results found.");
                    } else {
                        for (var Result : freeSearchResult){
                            System.out.println(Result);
                            System.out.println();
                        }
                    }

                    break;
                }
            }

        }
    }


    // +++++++++++++++ Read from file and build arrays ++++++++++++++++++++++++++++++++++++++


    public static ArrayList<Person> readFromFile() throws IOException {
        ArrayList<String> example = new ArrayList<>();
        ArrayList<Person> examplePersons = new ArrayList<Person>();
        File file = new File("Contacts.txt");

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            example.add(scan.nextLine());
        }

        String FirstName = "";
        String LastName = "";
        String Age = "";
        String PhoneNumber = "";
        String StreetName = "";
        String City = "";
        String PostalCode = "";
        String Doorcode = "";

        for (String s : example) {

            int a = (s.indexOf("First Name") + 13);
            int b = (s.indexOf("Last Name") - 3);
            for (int j = a; j < b; j++) {
                FirstName += (s.charAt(j));
            }

            a = (s.indexOf("Last Name") + 12);
            b = (s.indexOf("Age") - 3);
            for (int j = a; j < b; j++) {
                LastName += (s.charAt(j));
            }

            a = (s.indexOf("Age") + 5);
            b = (s.indexOf("Phone Number") - 2);
            for (int j = a; j < b; j++) {
                Age += (s.charAt(j));
            }

            a = (s.indexOf("Phone Number") + 15);
            b = (s.indexOf("Address") - 3);
            for (int j = a; j < b; j++) {
                PhoneNumber += (s.charAt(j));
            }

            a = (s.indexOf("Street Name") + 14);
            b = (s.indexOf("City") - 3);
            for (int j = a; j < b; j++) {
                StreetName += (s.charAt(j));
            }

            a = (s.indexOf("City") + 7);
            b = (s.indexOf("Postal Code") - 3);
            for (int j = a; j < b; j++) {
                City += (s.charAt(j));
            }

            a = (s.indexOf("Postal Code") + 14);
            b = (s.indexOf("Door Code") - 3);
            for (int j = a; j < b; j++) {
                PostalCode += (s.charAt(j));
            }

            a = (s.indexOf("Door Code") + 12);
            b = (s.length() - 1);
            for (int j = a; j < b; j++) {
                Doorcode += (s.charAt(j));
            }

            examplePersons.add(new Person(FirstName, LastName, Integer.valueOf(Age), new String[]{PhoneNumber}, new Address(StreetName, City, PostalCode, Doorcode)));
            System.out.println();
            FirstName = "";
            LastName = "";
            Age = "";
            PhoneNumber = "";
            StreetName = "";
            City = "";
            PostalCode = "";
            Doorcode = "";

        }
        return examplePersons;
    }


//    public static ArrayList<Person> generateExamplePersons() {
//        //Example persons
//        ArrayList<Person> examplePersons = new ArrayList<Person>();
//
//        Address address1 = new Address("Storvägen 13", "Uppsala", "75644", "6798");
//        Address address2 = new Address("Lillgatan 3", "Stockholm", "12345", "8390");
//        Address address3 = new Address("Götgatan 118", "Jönköping", "54321", "3385");
//        Address address4 = new Address("Pinngatan", "Umeå", "11337", "5687");
//        Address address5 = new Address("Leafstreet", "London", "87878", "2295");
//        Person person1 = new Person(
//                "Tratt",
//                "Trattson",
//                45,
//                new String[]{"0701234567"},
//                address1
//        );
//        Person person2 = new Person(
//                "Olof",
//                "Palme",
//                45,
//                new String[]{"07099889"},
//                address2
//        );
//        Person person3 = new Person(
//                "Margareta",
//                "Andersson",
//                45,
//                new String[]{"070444455"},
//                address3
//        );
//        Person person4 = new Person(
//                "Johnny",
//                "Depp",
//                45,
//                new String[]{"07011122"},
//                address4
//        );
//        Person person5 = new Person(
//                "Morgan",
//                "Alling",
//                45,
//                new String[]{"072133737"},
//                address5
//        );
//
//
//        examplePersons.add(person1);
//        examplePersons.add(person2);
//        examplePersons.add(person3);
//        examplePersons.add(person4);
//        examplePersons.add(person5);
//
//        return examplePersons;
//    }


    public static void readDeletedFile() throws IOException {

        File file = new File("RemovedContacts.txt");

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println((scan.nextLine()));
        }
    }

    public static void readModifiedFile() throws IOException {

        File file = new File("ModifiedContacts.txt");

        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()) {
            System.out.println((scan.nextLine()));
        }
    }
}