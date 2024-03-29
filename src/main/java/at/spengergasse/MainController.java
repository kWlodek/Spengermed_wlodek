package at.spengergasse;

import java.time.LocalDate;

import at.spengergasse.repositories.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import at.spengergasse.model.Patient;

@Controller    // This means that this class is a Controller
@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class MainController {
	@Autowired // This means to get the bean called patientRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private IPatientRepository patientRepository;
	@GetMapping(path="/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser () {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Patient p = new Patient();
		p.setBirthDate(LocalDate.now());
		p.setGender(Patient.GESCHLECHT.female);
		//Address a = new Address();
		//p.setAdress(a);
		patientRepository.save(p);
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Patient> getAllPatients() {
		// This returns a JSON or XML with the users
		return patientRepository.findAll();
	}

}


