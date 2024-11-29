public class Address {
    String StreetName;
    String city;
    String postalCode;

    @Override
    public String toString() {
        return "StreetName: '" + StreetName + '\'' +
                ", City: '" + city + '\'' +
                ", PostalCode: '" + postalCode + '\'';
    }

    public Address(String StreetName, String city, String postalCode) {
        this.StreetName = StreetName;
        this.city = city;
        this.postalCode = postalCode;
    }
}
