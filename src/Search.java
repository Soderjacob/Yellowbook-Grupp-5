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
            if (person.getFirstName().toLowerCase().contains(firstName)) {
                results.add(person);
            }
        }
        return results;
    }

    public Person searchByLastName(String lastName) {
        for (Person person : contacts) {
            if (person.getLastName().toLowerCase().contains(lastName)) {
                return person;
            }
        }
        return null; // No match found
    }

    public List<Person> searchByStreetName(String streetName) {
        List<Person> results = new ArrayList<>();
        for (Person person : contacts) {
            if (person.getAddress().StreetName.toLowerCase().contains(streetName)) {
                results.add(person);
            }
        }
        return results;
    }

    public List<Person> freeSearch(String query) {
        List<Person> results = new ArrayList<>();
        query = query.toLowerCase();
        for (Person person : contacts) {
            if (person.getFirstName().toLowerCase().contains(query) ||
                    person.getLastName().toLowerCase().contains(query) ||
                    person.getAddress().StreetName.toLowerCase().contains(query) ||
                    person.getAddress().city.toLowerCase().contains(query) ||
                    person.getAddress().postalCode.toLowerCase().contains(query)) {
                results.add(person);
            }
        }
        return results;
    }
}
