package at.spengergasse.Controller;

import at.spengergasse.repositories.IPractitionerRepository;
import at.spengergasse.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

public class ParticipantController {

    @Autowired
    private IPractitionerRepository practitionerRepository;

    //Get Practitioner by ID
    @GetMapping("/{id}")
    public ResponseEntity<Practitioner> getPractitioner(@PathVariable String id){
        Practitioner practitioner = practitionerRepository.findById(id).get();
        if(practitioner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(practitioner);
    }

    //Get all Practitioners
    @GetMapping()
    public ResponseEntity<Iterable<Practitioner>> getPractitioners(){
        return new ResponseEntity <Iterable<Practitioner>> (practitionerRepository.findAll(), HttpStatus.OK);
    }

    // Create a new Practitioner
    @PostMapping()
    public Practitioner createPractitioner(@Valid @RequestBody Practitioner practitioner) {
        return practitionerRepository.save(practitioner);
    }

    // Update a Practitioner
    @PutMapping("/{id}")
    public ResponseEntity<Practitioner> updatePractitioner(@PathVariable(value = "id") String practitionerId,
                                                           @Valid @RequestBody Practitioner practitionerDetails) {
        Practitioner practitioner = practitionerRepository.findById(practitionerId).get();
        if(practitioner == null) {
            return ResponseEntity.notFound().build();
        }

        //practitioner.setName(practitionerDetails.getName());
        practitioner.setGender(practitionerDetails.getGender());
        practitioner.setIdentifiers(practitionerDetails.getIdentifiers());
        //practitioner.setActive(practitionerDetails.isActive());
        practitioner.setBirthDate(practitionerDetails.getBirthDate());
        practitioner.setAddress(practitionerDetails.getAddress());
        //practitioner.setDeceased(practitionerDetails.getDeceased());

        Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
        return ResponseEntity.ok(updatedPractitioner);
    }

    // Delete a Practitioner
    @DeleteMapping("/{id}")
    public ResponseEntity<Practitioner> deletePractitioner(@PathVariable(value = "id") String practitionerId) {
        Practitioner practitioner = practitionerRepository.findById(practitionerId).get();
        if(practitioner == null) {
            return ResponseEntity.notFound().build();
        }
        practitionerRepository.delete(practitioner);
        return ResponseEntity.ok().build();
    }

}
