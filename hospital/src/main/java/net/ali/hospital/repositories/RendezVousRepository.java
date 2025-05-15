package net.ali.hospital.repositories;

import net.ali.hospital.entities.Patient;
import net.ali.hospital.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RendezVousRepository extends JpaRepository<RendezVous, String> {
}
