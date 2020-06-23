package phonebook;

public class PhoneNumber {
    private String name;
    private String number;

    public PhoneNumber(String number, String name) {
        this.name=name;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }
}
