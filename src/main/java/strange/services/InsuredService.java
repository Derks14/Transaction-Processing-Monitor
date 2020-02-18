package strange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strange.models.Insured;
import strange.repository.InsuredRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InsuredService {

    @Autowired
    private InsuredRepository repository;


    public List<Insured> getAllInsured(){
        List<Insured> insureds = new ArrayList<Insured>();
        repository.findAll().forEach(insureds::add);
        return insureds;
    }

    public Insured getInsured(Long id){
        Optional<Insured> first = repository.findById(id);
        if (first.isEmpty()){
            return null;
        }
        return first.get();
    }
    public void addInsured(Insured insured){
        repository.save(insured);
    }

    public void updateInsured(Long id, Insured insured){
        try {
            Insured newInsured = this.getInsured(id);
            repository.delete(newInsured);
            repository.save(insured);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteInsured(Long id){
        repository.deleteById(id);
    }
}
