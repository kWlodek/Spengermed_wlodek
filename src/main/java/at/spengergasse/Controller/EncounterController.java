package at.spengergasse.Controller;

import at.spengergasse.repositories.IEncounterRepository;
import at.spengergasse.model.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/encounter") // This means URL's start with /api/Encounter(after Application path)
public class EncounterController {

    @Autowired
    private IEncounterRepository encounterRepository;

    //Get Encounter by ID
    @GetMapping("/{id}")
    public ResponseEntity<Encounter> getEncounter(@PathVariable String id){
        Encounter Encounter = encounterRepository.findById(id).get();
        if(Encounter == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Encounter);
    }

    //Get all Encounters
    @GetMapping()
    public ResponseEntity<Iterable<Encounter>> getEncounters(){
        return new ResponseEntity <Iterable<Encounter>> (encounterRepository.findAll(), HttpStatus.OK);
    }

    // Create a new Encounter
    @PostMapping()
    public Encounter createEncounter(@Valid @RequestBody Encounter Encounter) {
        return encounterRepository.save(Encounter);
    }

    // Update a Encounter
    @PutMapping("/{id}")
    public ResponseEntity<Encounter> updateEncounter(@PathVariable(value = "id") String EncounterId,
                                                     @Valid @RequestBody Encounter encounterDetails) {
        Encounter encounter = encounterRepository.findById(EncounterId).get();
        if(encounter == null) {
            return ResponseEntity.notFound().build();
        }

        encounter.setStatus(encounterDetails.getStatus());
        encounter.setPeriod(encounterDetails.getPeriod());
        encounter.setEclass(encounterDetails.getEclass());
        encounter.setServiceType(encounterDetails.getServiceType());
        encounter.setPriority(encounterDetails.getPriority());
        encounter.setSubject(encounterDetails.getSubject());
        encounter.setLength(encounterDetails.getLength());
        encounter.setServiceProvider(encounterDetails.getServiceProvider());
        encounter.setPartOf(encounterDetails.getPartOf());
        encounter.setHospitalization(encounterDetails.getHospitalization());
        encounter.setIdentifier(encounterDetails.getIdentifier());
        encounter.setStatusHistory(encounterDetails.getStatusHistory());
        encounter.setClassHistory(encounterDetails.getClassHistory());
        encounter.setType(encounterDetails.getType());
        encounter.setEpisodeOfCare(encounterDetails.getEpisodeOfCare());
        encounter.setBasedOn(encounterDetails.getBasedOn());
        encounter.setParticipants(encounterDetails.getParticipants());
        encounter.setAppointment(encounterDetails.getAppointment());
        encounter.setReasonCode(encounterDetails.getReasonCode());
        encounter.setReasonReference(encounterDetails.getReasonReference());
        encounter.setDiagnoses(encounterDetails.getDiagnoses());
        encounter.setAccount(encounterDetails.getAccount());
        encounter.setLocations(encounterDetails.getLocations());

        Encounter updatedEncounter = encounterRepository.save(encounter);
        return ResponseEntity.ok(updatedEncounter);
    }

    // Delete a Encounter
    @DeleteMapping("/{id}")
    public ResponseEntity<Encounter> deleteEncounter(@PathVariable(value = "id") String encounterId) {
        Encounter encounter = encounterRepository.findById(encounterId).get();
        if(encounter == null) {
            return ResponseEntity.notFound().build();
        }
        encounterRepository.delete(encounter);
        return ResponseEntity.ok().build();
    }
}
