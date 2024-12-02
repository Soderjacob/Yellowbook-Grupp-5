public class Address {
    String StreetName;
    String city;
    String postalCode;
    String doorCode;

    @Override
    public String toString() {
        return "StreetName: '" + StreetName + '\'' +
                ", City: '" + city + '\'' +
                ", PostalCode: '" + postalCode + '\'' + ", Doorcode: '" + doorCode + '\'';
    }

    public Address(String StreetName, String city, String postalCode, String doorCode) {
        this.StreetName = StreetName;
        this.city = city;
        this.postalCode = postalCode;
        this.doorCode = doorCode;
    }
}
