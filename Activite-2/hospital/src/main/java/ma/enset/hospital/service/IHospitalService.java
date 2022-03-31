package ma.enset.hospital.service;

import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medcin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;


public interface IHospitalService
{
    //methode pour ajouter un patient
     Patient savePatient(Patient patient);
     Medcin saveMedecin(Medcin medcin);
     RendezVous saveRendezVous (RendezVous rendezVous);
     Consultation saveConsultation(Consultation consultation);

}
