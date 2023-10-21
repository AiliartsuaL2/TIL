package section4.item17;

public class Address {
    private String zipCode;
    private String street;
    private String city;

    public Address() {
    }

    public Address(String zipCode, String street, String city) {
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }
    // setter를 제공 > 가변 컴포넌트
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
