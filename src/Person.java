import java.util.Arrays;

public class Person {
    String firstName;
    String lastName;
    Integer age;
    String[] phoneNumbers;
    Address address;

    @Override
    public String toString() {
        return "Person" +
                "FirstName: '" + firstName + '\'' +
                ", LastName: '" + lastName + '\'' +
                ", Age: " + age +
                ", PhoneNumber: " + Arrays.toString(phoneNumbers) +
                ", Address: " + address.toString();
    }

    public Person(String firstName, String lastName, Integer age, String[] phoneNumbers, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }
}
