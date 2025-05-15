package net.ali.hospital.repositories;

import net.ali.hospital.entities.Consultation;
import net.ali.hospital.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
