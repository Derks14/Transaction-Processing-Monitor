package strange.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import strange.models.Migrant;

import java.util.List;

public interface MigrantRepository extends MongoRepository<Migrant, String> {
    public Migrant findByFirstname(String firstname);
    public List<Migrant> findByLastname(String lastname);
}
