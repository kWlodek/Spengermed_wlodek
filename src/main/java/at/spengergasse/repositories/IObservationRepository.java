package at.spengergasse.repositories;

import at.spengergasse.model.Observation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IObservationRepository extends JpaRepository<Observation, String> {
}
