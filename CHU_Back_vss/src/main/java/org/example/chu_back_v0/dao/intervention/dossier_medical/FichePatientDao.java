package org.example.chu_back_v0.dao.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FichePatientDao extends JpaRepository<FichePatient, Long> {
    FichePatient findByRef(String ref);

    int deleteByRef(String ref);
}
