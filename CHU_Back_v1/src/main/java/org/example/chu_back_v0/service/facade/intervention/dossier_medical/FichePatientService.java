package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;

import java.util.List;

public interface FichePatientService {
    FichePatient findByRef(String ref);

    int deleteByRef(String ref);

    List<FichePatient> findAll();

    int save(FichePatient FichePatient);
}
