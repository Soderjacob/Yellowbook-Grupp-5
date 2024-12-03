import java.util.ArrayList;
import java.util.List;

public class Search  {
    private List<Person> contacts;

    public Search (ArrayList<Person> contacts) {
        this.contacts = contacts;
    }

    public void addPerson(Person person) {
        contacts.add(person);
    }

    public List<Person> searchByFirstName(String firstName) {
        List<Person> results = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(firstName)) {
                results.add(person);
            }
        }
        return results;
    }

    public Person searchByLastName(String lastName) {
        for (Person person : contacts) {
            if (person.getLastName().equalsIgnoreCase(lastName)) {
                return person;
            }
        }
        return null; // No match found
    }

    public List<Person> searchByStreetName(String streetName) {
        List<Person> results = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getAddress().StreetName.equalsIgnoreCase(streetName)) {
                results.add(person);
            }
        }
        return results;
    }

    public List<Person> freeSearch(String query) {
        List<Person> results = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getFirstName().equalsIgnoreCase(query) ||
                    person.getLastName().equalsIgnoreCase(query) ||
                    person.getAddress().StreetName.equalsIgnoreCase(query) ||
                    person.getAddress().city.equalsIgnoreCase(query) ||
                    person.getAddress().postalCode.equalsIgnoreCase(query)) {
                results.add(person);
            }
        }
        return results;
    }
}
