package at.spengergasse.repositories;

import at.spengergasse.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILocationRepository extends JpaRepository<Location, String> {
}
