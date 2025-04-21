package org.example.chu_back_v0.dao.patient;

import org.example.chu_back_v0.bean.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {
    Patient findByNumDossier(String numDossier);

    int deleteByNumDossier(String numDossier);
}
