import java.util.ArrayList;
import java.util.List;

public class Search  {
    private List<Person> contacts;

    public Search (ArrayList<Person> contacts) {
        this.contacts = contacts;
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
            if (person.getFirstName().toLowerCase().contains(query.toLowerCase()) ||
                    person.getLastName().toLowerCase().contains(query.toLowerCase()) ||
                    person.getAddress().StreetName.toLowerCase().contains(query.toLowerCase()) ||
                    person.getAddress().city.toLowerCase().contains(query.toLowerCase()) ||
                    person.getAddress().postalCode.toLowerCase().contains(query.toLowerCase())) {
                results.add(person);
            }
        }
        return results;
    }
}
