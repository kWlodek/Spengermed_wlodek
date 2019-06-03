package at.spengergasse.Controller;


import at.spengergasse.repositories.IPractitionerRepository;
import at.spengergasse.model.Practitioner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/practitioner") // This means URL's start with /api/practitioner(after Application path)
public class PractitionerController {

	@Autowired
	private IPractitionerRepository practitionerRepository;

	//Get practitioner by ID
	@GetMapping("/{id}")
	public ResponseEntity<Practitioner> getPractitioner(@PathVariable String id){
		Practitioner practitioner = practitionerRepository.findById(id).get();
		if(practitioner == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(practitioner);
	}

	//Get all practitioners
	@GetMapping()
	public ResponseEntity<Iterable<Practitioner>> getPractitioner(){
		return new ResponseEntity <Iterable<Practitioner>> (practitionerRepository.findAll(), HttpStatus.OK);
	}

	// Create a new practitioner
	@PostMapping()
	public Practitioner createPractitioner(@Valid @RequestBody Practitioner practitioner) {
		return practitionerRepository.save(practitioner);
	}

	// Update a practitioner
	@PutMapping("/{id}")
	public ResponseEntity<Practitioner> updatePractitioner(@PathVariable(value = "id") String practitionerId,
														   @Valid @RequestBody Practitioner practitionerDetails) {
		Practitioner practitioner = practitionerRepository.findById(practitionerId).get();
		if(practitioner == null) {
			return ResponseEntity.notFound().build();
		}


		practitioner.setGender(practitionerDetails.getGender());
		practitioner.setBirthDate(practitionerDetails.getBirthDate());
		practitioner.setAddress(practitionerDetails.getAddress());
		practitioner.setIdentifiers(practitionerDetails.getIdentifiers());
		practitioner.setNames(practitionerDetails.getNames());
		practitioner.setBirthDate(practitionerDetails.getBirthDate());
		practitioner.setActive(practitionerDetails.getActive());


		Practitioner updatedPractitioner = practitionerRepository.save(practitioner);
		return ResponseEntity.ok(updatedPractitioner);
	}

	// Delete a practitioner
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
