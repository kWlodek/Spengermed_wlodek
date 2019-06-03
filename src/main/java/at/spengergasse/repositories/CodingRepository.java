package at.spengergasse.repositories;

import at.spengergasse.model.Coding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;


public interface CodingRepository extends JpaRepository<Coding,Long> {
	Set<Coding> findByCodeAndSystemAndVersion(String code, String system, String version);
}
