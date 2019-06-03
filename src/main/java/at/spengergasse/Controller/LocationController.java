package at.spengergasse.Controller;

import at.spengergasse.model.Location;
import at.spengergasse.repositories.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/location")
public class LocationController {

    //Patient Repository Instance used to perform CRUD operations
    @Autowired
    private ILocationRepository locationRepository;



    //Get Observation by ID
    @GetMapping("/{id}")
    public ResponseEntity<Location> getLocation(@PathVariable String id){
        Location location = locationRepository.findById(id).get();
        if(location == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(location);
    }



    //Get all Observations
    @GetMapping()
    public ResponseEntity<Iterable<Location>> getLocations(){
        return new ResponseEntity <Iterable<Location>> (locationRepository.findAll(), HttpStatus.OK);
    }



    // Create a new Observation
    @PostMapping()
    public Location createLocation(@Valid @RequestBody Location location) {
        return locationRepository.save(location);
    }



    // Update an Observation
    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable(value = "id") String locationId,
                                                         @Valid @RequestBody Location locationDetails) {
        Location location = locationRepository.findById(locationId).get();
        if(location == null) {
            return ResponseEntity.notFound().build();
        }

        location.setHoo(locationDetails.getHoo());
        location.setMode(locationDetails.getMode());
        location.setPartOf(locationDetails.getPartOf());
        location.setOperationStatus(locationDetails.getOperationStatus());
        location.setPhysicalType(locationDetails.getPhysicalType());

        Location updatedLocation = locationRepository.save(location);
        return ResponseEntity.ok(updatedLocation);
    }



    // Delete a Observation
    @DeleteMapping("/{id}")
    public ResponseEntity<Location> deleteLocation(@PathVariable(value = "id") String locationId) {
        Location location = locationRepository.findById(locationId).get();
        if(location == null) {
            return ResponseEntity.notFound().build();
        }
        locationRepository.delete(location);
        return ResponseEntity.ok().build();
    }

}
