package strange.repository;

import org.springframework.data.repository.CrudRepository;
import strange.models.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long> {
    public Voter findByLastname(String lastname);
    public Voter findByFirstnameAndLastname(String firstname, String lastname);

}
