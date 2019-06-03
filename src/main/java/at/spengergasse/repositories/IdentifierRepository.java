package at.spengergasse.repositories;

import at.spengergasse.model.Identifier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentifierRepository extends JpaRepository<Identifier, Long> {

}
