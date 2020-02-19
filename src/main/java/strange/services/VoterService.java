package strange.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import strange.models.Voter;
import strange.repository.VoterRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VoterService {

    @Autowired
    private VoterRepository repository;

    public List<Voter> getAllVoters(){
        List<Voter> results = new ArrayList<Voter>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public Voter getVoters(Long votersId) {
        Optional<Voter> voterFirst = repository.findById(votersId);
        if (voterFirst.isEmpty()){
            return null;
        }
        return voterFirst.get();
    }

    public void addVoter(Voter  voter){
        repository.save(voter);
    }

    public void updateVoter(Long votersId, Voter voter){
        try {
            Voter newVoter = this.getVoters(votersId);
            repository.delete(newVoter);
            repository.save(voter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVoter(Long votersID){
        repository.deleteById(votersID);
    }
}
