package strange.models;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@NodeEntity
public class Voter {

    @Id @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String age;

    public Voter() {
    }

    @Relationship(type = "FAMILY", direction = Relationship.UNDIRECTED)
    public Set<Voter> families;

    public void relatedTo(Voter voter){
        if (families == null){
            families = new HashSet<>();
        }
        families.add(voter);
    }

    public String toString() {
        return this.lastname + " " + this.firstname + "'s families => "
                + Optional.ofNullable(this.families).orElse(
                Collections.emptySet()).stream()
                .map(Voter::getLastname).collect(Collectors.toList());
    }

    public Voter(String lastname) {
        this.lastname = lastname;
    }

    public Voter(Long id, String firstname, String lastname, String age) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
