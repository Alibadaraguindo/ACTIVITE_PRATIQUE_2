package net.ali.hospital.services;

import net.ali.hospital.entities.Consultation;
import net.ali.hospital.entities.Medecin;
import net.ali.hospital.entities.Patient;
import net.ali.hospital.entities.RendezVous;

public interface IHospitalService {
    Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
