package net.ali.hospital.services;

import jakarta.transaction.Transactional;
import net.ali.hospital.entities.Consultation;
import net.ali.hospital.entities.Medecin;
import net.ali.hospital.entities.Patient;
import net.ali.hospital.entities.RendezVous;
import net.ali.hospital.repositories.ConsultationRepository;
import net.ali.hospital.repositories.MedecinRepository;
import net.ali.hospital.repositories.PatientRepository;
import net.ali.hospital.repositories.RendezVousRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional

public class HospitalServiceImpl implements IHospitalService {
    private PatientRepository patientRepository;
    private ConsultationRepository consultationRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    public HospitalServiceImpl(PatientRepository patientRepository,
                               ConsultationRepository consultationRepository,
                               MedecinRepository medecinRepository,
                               RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.consultationRepository = consultationRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
    }
    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
