package org.example.chu_back_v0.service.facade.patient;

import org.example.chu_back_v0.bean.patient.Patient;

import java.util.List;

public abstract interface PatientService {
    public abstract Patient findByNumDossier(String numDossier);

    public abstract int deleteByNumDossier(String numDossier);

    public abstract List<Patient> findAll();

    public abstract int save(Patient patient);
}
