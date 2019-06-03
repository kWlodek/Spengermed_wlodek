package at.spengergasse.Controller;

import at.spengergasse.repositories.IPatientRepository;
import at.spengergasse.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/api/patient") // This means URL's start with /api/patient(after Application path)
public class PatientController  {

	@Autowired
	private IPatientRepository patientRepository;

	//Get Patient by ID
	@GetMapping("/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable String id){
		Patient patient = patientRepository.findById(id).get();
		if(patient == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(patient);
	}

	//Get all Patients
	@GetMapping()
	public ResponseEntity<Iterable<Patient>> getPatients(){
		return new ResponseEntity <Iterable<Patient>> (patientRepository.findAll(), HttpStatus.OK);
	}

	// Create a new Patient
	@PostMapping()
	public Patient createPatient(@Valid @RequestBody Patient patient) {
		return patientRepository.save(patient);
	}

	// Update a Patient
	@PutMapping("/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") String patientId,
												 @Valid @RequestBody Patient patientDetails) {
		Patient patient = patientRepository.findById(patientId).get();
		if(patient == null) {
			return ResponseEntity.notFound().build();
		}

		//patient.setName(patientDetails.getName());
		patient.setGender(patientDetails.getGender());
		patient.setIdentifiers(patientDetails.getIdentifiers());
		//patient.setActive(patientDetails.isActive());
		patient.setBirthDate(patientDetails.getBirthDate());
		patient.setAddress(patientDetails.getAddress());
		//patient.setDeceased(patientDetails.getDeceased());

		Patient updatedPatient = patientRepository.save(patient);
		return ResponseEntity.ok(updatedPatient);
	}

	// Delete a Patient
	@DeleteMapping("/{id}")
	public ResponseEntity<Patient> deletePatient(@PathVariable(value = "id") String patientId) {
		Patient patient = patientRepository.findById(patientId).get();
		if(patient == null) {
			return ResponseEntity.notFound().build();
		}
		patientRepository.delete(patient);
		return ResponseEntity.ok().build();
	}

}
