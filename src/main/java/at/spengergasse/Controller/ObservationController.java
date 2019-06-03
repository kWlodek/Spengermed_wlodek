package at.spengergasse.Controller;

import at.spengergasse.repositories.IObservationRepository;
import at.spengergasse.model.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path="/api/observation")
public class ObservationController {


    @Autowired
    private IObservationRepository observationRepository;



    @GetMapping("/{id}")
    public ResponseEntity<Observation> getObservation(@PathVariable String id){
        Observation observation = observationRepository.findById(id).get();
        if(observation == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(observation);
    }




    @GetMapping()
    public ResponseEntity<Iterable<Observation>> getObservations(){
        return new ResponseEntity <Iterable<Observation>> (observationRepository.findAll(), HttpStatus.OK);
    }




    @PostMapping()
    public Observation createObservation(@Valid @RequestBody Observation observation) {
        return observationRepository.save(observation);
    }



    // Update an Observation
    @PutMapping("/{id}")
    public ResponseEntity<Observation> updateObservation(@PathVariable(value = "id") String observationId,
                                                         @Valid @RequestBody Observation observationDetails) {
        Observation observation = observationRepository.findById(observationId).get();
        if(observation == null) {
            return ResponseEntity.notFound().build();
        }

        observation.setIdentifiers(observationDetails.getIdentifiers());
        observation.setCode(observationDetails.getCode());
        observation.setPartOf(observationDetails.getPartOf());
        observation.setStatus(observationDetails.getStatus());

        Observation updatedObservation = observationRepository.save(observation);
        return ResponseEntity.ok(updatedObservation);
    }



    // Delete a Observation
    @DeleteMapping("/{id}")
    public ResponseEntity<Observation> deleteObservation(@PathVariable(value = "id") String observationId) {
        Observation observation = observationRepository.findById(observationId).get();
        if(observation == null) {
            return ResponseEntity.notFound().build();
        }
        observationRepository.delete(observation);
        return ResponseEntity.ok().build();
    }

}
