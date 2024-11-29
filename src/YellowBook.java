import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class YellowBook {
    public static void main(String[] args) {
        //Admins login password
        Integer adminsPassword = 1337;
        //Example persons
        ArrayList<Person> examplePersons = generateExamplePersons();

        //create admin
        AdminRights admin = new AdminRights(examplePersons);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to yellowbook");

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
        while(showMenuLoop) {
            //Visible menu
            System.out.println("----Menu----");
            System.out.println("1: Search");
            System.out.println("2: Quit");
            if (userIsAdmin) {
                System.out.println("3: Add person");
                System.out.println("4: Edit person");
                System.out.println("5: Display all persons");
            }

            Integer userMenuChoice = scanner.nextInt();


            switch (userMenuChoice) {
                case 1: {
                    //searchFunction

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
                        //function edit person

                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }
                case 5: {
                    if (userIsAdmin) {
                        //function display all
                        admin.displayContacts();
                    } else {
                        System.out.println("Something went wrong.");
                    }
                    break;
                }

            }
        }
    }
        public static ArrayList<Person> generateExamplePersons () {
            //Example persons
            ArrayList<Person> examplePersons = new ArrayList<Person>();

            Address address1 = new Address("Storvägen 13", "Uppsala", "75644");
            Address address2 = new Address("Lillgatan 3", "Stockholm", "12345");
            Address address3 = new Address("Götgatan 118", "Jönköping", "54321");
            Address address4 = new Address("Pinngatan", "Umeå", "11337");
            Address address5 = new Address("Leafstreet", "London", "87878");
            Person person1 = new Person(
                    "Tratt",
                    "Trattson",
                    45,
                    new String[]{"0701234567"},
                    address1
            );
            Person person2 = new Person(
                    "Olof",
                    "Palme",
                    45,
                    new String[]{"07099889"},
                    address1
            );
            Person person3 = new Person(
                    "Margareta",
                    "Andersson",
                    45,
                    new String[]{"070444455"},
                    address1
            );
            Person person4 = new Person(
                    "Johnny",
                    "Depp",
                    45,
                    new String[]{"07011122"},
                    address1
            );
            Person person5 = new Person(
                    "Morgan",
                    "Alling",
                    45,
                    new String[]{"072133737"},
                    address1
            );


            examplePersons.add(person1);
            examplePersons.add(person2);
            examplePersons.add(person3);
            examplePersons.add(person4);
            examplePersons.add(person5);

            return examplePersons;
        }

}
