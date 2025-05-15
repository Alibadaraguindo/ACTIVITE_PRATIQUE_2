package net.ali.tp2_1.repository;

import net.ali.tp2_1.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findAll();
    Patient findPatientByNom(String nom);

}
