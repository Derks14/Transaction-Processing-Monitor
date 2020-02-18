package strange.services;


// newlife texturizer

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import strange.models.Driver;
import strange.repository.DriverRepository;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    @Autowired
    private DriverRepository driverRepository;

    public List<Driver> getAllDrivers(){
        List<Driver> drivers = new ArrayList<Driver>();
        driverRepository.findAll().forEach(drivers::add);
        return drivers;
    }

    public Driver getDriver(Long licenceNumber)  {
        Optional<Driver> driverFirst = driverRepository.findById(licenceNumber);
        if (driverFirst.isEmpty()){
            String error = licenceNumber + "Not Found";
            return null;
        }
        return driverFirst.get();
    }

    public void addDriver(Driver driver){
        driverRepository.save(driver);
    }

    public void updateDriver(Long licenceNumber, Driver driver){
        try {
            Driver newDriver = this.getDriver(licenceNumber);
            driverRepository.delete(newDriver);
            driverRepository.save(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteDriver(Long licenceNumber){
        driverRepository.deleteById(licenceNumber);
    }

}
