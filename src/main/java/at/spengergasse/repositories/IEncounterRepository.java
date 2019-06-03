package at.spengergasse.repositories;

import at.spengergasse.model.Encounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEncounterRepository extends JpaRepository<Encounter, String> {
}
