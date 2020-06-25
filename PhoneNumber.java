package phonebook;

import org.jetbrains.annotations.NotNull;

public class PhoneNumber implements Comparable<PhoneNumber>{
    private String name;
    private String number;

    public PhoneNumber(String number, String name){
        this.name=name;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
    public String firstName(){
        String[] names = name.split(" ");

            return names[0];
    }

    public String lastName(){
        String[] names = name.split(" ");

        return names.length > 1 ? names[1] : "";
    }
    @Override
    public int compareTo(@NotNull PhoneNumber phoneNumber) {

        return name.compareTo(phoneNumber.getName())  ;
    }
}
