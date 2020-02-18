package strange.repository;

import org.springframework.data.repository.CrudRepository;
import strange.models.Driver;

import java.util.List;

public interface DriverRepository extends CrudRepository<Driver,Long> {
    public Driver findByLicenceNumber(Long License);
    public List<Driver> findByLicenceClass(Character licenceClass);

}
