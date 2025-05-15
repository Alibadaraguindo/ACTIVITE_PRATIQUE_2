package net.ali.tp2_1;

import net.ali.tp2_1.entities.Patient;
import net.ali.tp2_1.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import static net.ali.tp2_1.entities.Patient.*;

@SpringBootApplication
public class Tp21Application {

    public static void main(String[] args) {
        SpringApplication.run(Tp21Application.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            // Ajouter quelques patients normaux
            patientRepository.save(builder().Nom("Ali").dateNaissance(new Date()).malade(true).score(100).build());
            patientRepository.save(builder().Nom("Fatima").dateNaissance(new Date()).malade(false).score(120).build());
            patientRepository.save(builder().Nom("Mohamed").dateNaissance(new Date()).malade(true).score(80).build());
            patientRepository.save(builder().Nom("Khadija").dateNaissance(new Date()).malade(false).score(90).build());
            patientRepository.save(builder().Nom("Omar").dateNaissance(new Date()).malade(true).score(110).build());

            // Ajouter quelques patients "Maliens"
            patientRepository.save(builder().Nom("Mamadou (Mali)").dateNaissance(new Date()).malade(false).score(105).build());
            patientRepository.save(builder().Nom("Aminata (Mali)").dateNaissance(new Date()).malade(true).score(95).build());
            patientRepository.save(builder().Nom("Seydou (Mali)").dateNaissance(new Date()).malade(false).score(88).build());

            System.out.println("\n Tous les patients ont été ajoutés !");

            System.out.println("\n Consulter tous les patients !");
            patientRepository.findAll().forEach(System.out::println);

           Patient patient= patientRepository.findPatientByNom("Ali");
            String string = patient.toString();
            System.out.println(string);

        };
    }
}
