package strange.models;

import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;

public class Migrant {

    @GeneratedValue
    @Id private String id;
    private String firstname;
    private String lastname;
    private int age;
    private String nationality;

    public Migrant() {
    }

    public Migrant(String firstname, String lastname, int age, String nationality) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.nationality = nationality;
    }



    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
