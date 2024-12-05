import java.io.Serializable;
import java.util.Arrays;

public class Person implements Serializable {
    String firstName;
    String lastName;
    Integer age;
    String[] phoneNumbers;
    Address address;

    @Override
    public String toString(){

        return " Person" +
                " First Name: '" + firstName + '\'' +
                ", Last Name: '" + lastName + '\'' +
                ", Age: " + age +
                ", Phone Number: " + Arrays.toString(phoneNumbers) +
                ", Address: " + address.toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Address getAddress() {
        return address;
    }

    public Person(String firstName, String lastName, Integer age, String[] phoneNumbers, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }
}
