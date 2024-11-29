public class Person {
    String firstName;
    String lastName;
    Integer age;
    String[] phoneNumbers;
    Address address;

    public Person(String firstName, String lastName, Integer age, String[] phoneNumbers, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
    }
}
