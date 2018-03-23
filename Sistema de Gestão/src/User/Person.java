package User;

public class Person {
    private String name;
    private int numbemID;
    private String address;

    public Person(String name, int numbemID, String address) {
        this.name = name;
        this.numbemID = numbemID;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumbemID() {
        return numbemID;
    }

    public void setNumbemID(int numbemID) {
        this.numbemID = numbemID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
