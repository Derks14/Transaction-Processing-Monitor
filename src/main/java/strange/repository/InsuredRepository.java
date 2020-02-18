package strange.repository;

import org.springframework.data.repository.CrudRepository;
import strange.models.Insured;

public interface InsuredRepository extends CrudRepository<Insured, Long> {

}
