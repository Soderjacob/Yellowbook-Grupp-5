import java.io.Serializable;

public class Address implements Serializable {
    String StreetName;
    String city;
    String postalCode;
    String doorCode;

    @Override
    public String toString() {
        return "Street Name: '" + StreetName + '\'' +
                ", City: '" + city + '\'' +
                ", Postal Code: '" + postalCode + '\'' + ", Door Code: '" + doorCode + '\'';
    }

    public Address(String StreetName, String city, String postalCode, String doorCode) {
        this.StreetName = StreetName;
        this.city = city;
        this.postalCode = postalCode;
        this.doorCode = doorCode;
    }
}