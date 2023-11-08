package work02;

import work01.Utilitor;

import java.util.Objects;

public class Person {
    private static int nextId = 1;
    private final int id;
    private String firstname;
    private String lastname;

    public Person(String firstname, String lastname) {
        this.firstname = Utilitor.testString(firstname, "Invalid Firstname");
        this.lastname = Utilitor.testString(lastname, "Invalid Lastname");
        this.id = nextId++;
    }

    @Override
    public String toString() {
        String sb = "person{" + "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
        return sb;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = Utilitor.testString(firstname, "");
    }

    public void setLastname(String lastname) {
        this.lastname = Utilitor.testString(lastname, "");
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
