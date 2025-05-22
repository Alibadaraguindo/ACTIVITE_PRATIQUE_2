# GUINDO BADARA ALIOU 2100000017 MASTER SDIA FSM



# Activité Pratique 2 – Gestion Hospitalière avec Spring Boot
Objectif du Projet
Ce projet a pour but de mettre en pratique les concepts fondamentaux de Spring Boot à travers la création d’une application de gestion hospitalière. L’activité consiste à modéliser des entités comme Patient, Médecin, Rendez-vous, Consultation, ainsi que la gestion des utilisateurs et rôles, en intégrant Spring Data JPA, Lombok, une base H2 dans un premier temps, puis MySQL, avec une interface de gestion simplifiée.
# Étapes Réalisées
# 1. Initialisation du Projet
Création d’un projet Spring Initializr avec IntelliJ IDEA Ultimate.
# 2. Création de l'entité Patient

Annotation avec @Entity, @Id, @GeneratedValue, @Data.

![image](https://github.com/user-attachments/assets/3d7f1abd-61f4-44ce-ab83-697600387dcc)

# 3. Configuration de la base de données H2
Fichier application.properties configuré pour :

activer H2 Console

utiliser le dialecte H2

activer ddl-auto=update pour la création automatique des tables

![image](https://github.com/user-attachments/assets/1e0cd4ac-0e60-4b63-8aae-0b3661b39b4d)
# 4. Création du Repository PatientRepository
Interface héritant de JpaRepository<Patient, Long>.

Méthodes personnalisées comme findByNomContains.
![image](https://github.com/user-attachments/assets/8baa7d02-0c33-4ed4-a579-bd221e3819c8)


# 5. Tests CRUD – Patients
Opérations réalisées via CommandLineRunner :

Création automatique de patients

 Consultation de tous les patients

 Recherche par nom

 Mise à jour d’un patient

 Suppression d’un patient

![image](https://github.com/user-attachments/assets/9580e032-8bfd-4c8e-9353-aaf6b78d3515)

# 6. Migration vers MySQL (projet hospital)
![image](https://github.com/user-attachments/assets/5b661ffa-bdb6-4f6d-a9c0-54a5b30084bd)


spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db

Création de la base hospital_db

Configuration du dialecte MySQL
# 7.Entités supplémentaires ajoutées(projet hospital) :

Medecin (nom, spécialité, email)

RendezVous (liens avec Patient et Médecin)

Consultation (liée à un rendez-vous)
![image](https://github.com/user-attachments/assets/c261ac3f-6f1d-41d0-a1fa-49fd6ccac7b6)
![image](https://github.com/user-attachments/assets/4ef10bd4-1c63-4ea3-9f13-3b757d70f85a)


![image](https://github.com/user-attachments/assets/781982d8-540c-4419-9ddc-d368c6039365)

# 8.Gestion des Rôles et Utilisateurs(projet jpa-enset)
Implémentation de Spring Security :

Ajout de rôles (USER, ADMIN)

![image](https://github.com/user-attachments/assets/db0bb80c-ce6c-4c58-a8b1-1d6bcd0003c3)
![image](https://github.com/user-attachments/assets/2988bdbc-28a5-4076-b556-adc2022b6763)

# Conclusion
Ce projet m’a permis de consolider mes compétences en développement d’applications web avec Spring Boot, notamment en modélisation JPA, manipulation de données avec Spring Data, et gestion de la sécurité avec Spring Security. Grâce à une approche progressive (de H2 à MySQL), j’ai pu mieux comprendre l’architecture d’une application Java complète, depuis la base de données jusqu’à la couche web. Cette activité a jeté des bases solides pour la création d’applications robustes et modulables, prêtes pour une évolution vers un front-end plus riche.


