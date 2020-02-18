package strange.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import strange.models.Driver;
import strange.models.Insured;
import strange.models.Migrant;
import strange.models.Voter;
import strange.services.DriverService;
import strange.services.InsuredService;
import strange.services.MigrantService;
import strange.services.VoterService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final MigrantService migrantService;
    private final DriverService driverService;
    private final InsuredService insuredService;
    private final VoterService voterService;

    @Autowired
    public Controller(MigrantService migrantService, DriverService driverService, InsuredService insuredService, VoterService voterService) {
        this.migrantService = migrantService;
        this.driverService = driverService;
        this.insuredService = insuredService;
        this.voterService = voterService;
    }

    @RequestMapping(value = "/persons/driver", method= RequestMethod.GET)
    @ResponseBody
    public List<Driver> getAllDriver(){
        if (driverService.getAllDrivers()!=null){
            return driverService.getAllDrivers();
        }
        return null;
    }
    @RequestMapping(value = "/persons/insured", method= RequestMethod.GET)
    @ResponseBody
    public List<Insured> getAllfromInsured(){
        if (insuredService.getAllInsured()!=null){
            return insuredService.getAllInsured();
        }
        return null;
    }

    @RequestMapping(value = "/persons/migrant", method = RequestMethod.GET)
    @ResponseBody
    public List<Migrant> getAllfromMigrant(){
        if (migrantService.getAllMigrants() != null){
            return migrantService.getAllMigrants();
        }
        return null;
    }

    @RequestMapping(value = "/persons/voter", method = RequestMethod.GET)
    @ResponseBody
    public List<Voter> getAllfromVoters(){
        if (voterService.getAllVoters() != null){
            return voterService.getAllVoters();
        }
        return null;
    }

    @RequestMapping(value = "/persons/driver", method= RequestMethod.POST)
    public ResponseEntity<Void> addDriver(@RequestBody Driver driver){
        driverService.addDriver(driver);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/persons/insured", method= RequestMethod.POST)
    public ResponseEntity<Void> addNewInsured(@RequestBody Insured insured){
        insuredService.addInsured(insured);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/persons/migrant", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewMigrant(@RequestBody Migrant migrant){
        migrantService.addMigrant(migrant);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @RequestMapping(value = "/persons/voter", method = RequestMethod.POST)
    public ResponseEntity<Void> addNewVoter(@RequestBody Voter voter){
        voterService.addVoter(voter);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

