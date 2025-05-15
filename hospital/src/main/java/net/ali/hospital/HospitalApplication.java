package net.ali.hospital;

import net.ali.hospital.entities.*;
import net.ali.hospital.repositories.ConsultationRepository;
import net.ali.hospital.repositories.MedecinRepository;
import net.ali.hospital.repositories.PatientRepository;
import net.ali.hospital.repositories.RendezVousRepository;
import net.ali.hospital.services.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService , PatientRepository patientRepository, RendezVousRepository rendezVousRepository,ConsultationRepository consultationRepository,MedecinRepository medecinRepository){
        return args -> {
            Stream.of("Ali", "Imane", "Hassan").forEach(name -> {
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);

            });
             Stream.of("Dr. Samir", "Dr. Laila", "Dr. Karim").forEach(name -> {
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setEmail(name +"@gmail.com");
                medecin.setSpecialite(Math.random() > 0.5 ? "Cardiologue" : "Dentiste");
                hospitalService.saveMedecin(medecin);
            });
             Patient patient = patientRepository.findById(1L).orElse(null);
             Patient patient1 = patientRepository.findByNom("Ali");


             Medecin medecin = medecinRepository.findByNom("Dr. Karim");


            RendezVous rendezVous = new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedecin(medecin);
            rendezVous.setPatient(patient);
            hospitalService.saveRDV(rendezVous);



            RendezVous rendezVous1 = rendezVousRepository.findAll().get(0);

            Consultation consultation = new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("RAPPORT:.......");
           hospitalService.saveConsultation(consultation);
        };


    }

}
