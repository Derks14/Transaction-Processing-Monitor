package strange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strange.models.Driver;
import strange.models.Migrant;
import strange.repository.MigrantRepository;

import java.util.List;

@Service
public class MigrantService {

    @Autowired
    private MigrantRepository repository;

    public List<Migrant> getAllMigrants(){
        return repository.findAll();
    }

    public Migrant getMigrant(String id){
        if (!repository.existsById(id)){
            return null;
        }
        return repository.findById(id).get();
    }

    public void updateMigrant(Migrant migrant, String id){
        if (repository.existsById(id)){
            repository.delete(this.getMigrant(id));
            repository.save(migrant);
        }else {
            repository.save(migrant);
        }
    }

    public void addMigrant(Migrant migrant){
        repository.save(migrant);
    }

    public void deleteMigrant(String id){
        repository.delete(this.getMigrant(id));
    }

}
