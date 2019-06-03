package at.spengergasse.repositories;

import at.spengergasse.model.Practitioner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPractitionerRepository extends JpaRepository<Practitioner, String> {
}
