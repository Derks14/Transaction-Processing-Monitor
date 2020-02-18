package strange.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//  sudo mysql --password
//  mysql> create database db_example; -- Creates the new database
//  mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
//  mysql> grant all on db_example.* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

@Entity
public class Driver {

    @Id
    @GeneratedValue
    private Long licenceNumber;
    private String firstname;
    private String lastname;
    private Integer age;
    private Character gender;
    private String nationality;
    private Character licenceClass;

    public Driver() {
    }

    public Long getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(Long licenceNumber) {
        this.licenceNumber = licenceNumber;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Character getLicenceClass() {
        return licenceClass;
    }

    public void setLicenceClass(Character licenceClass) {
        this.licenceClass = licenceClass;
    }
}
