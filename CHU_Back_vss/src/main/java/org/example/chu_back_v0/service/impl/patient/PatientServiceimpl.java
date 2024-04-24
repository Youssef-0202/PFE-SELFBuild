package org.example.chu_back_v0.service.impl.patient;

import org.example.chu_back_v0.bean.patient.Patient;
import org.example.chu_back_v0.dao.patient.PatientDao;
import org.example.chu_back_v0.service.facade.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceimpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Override
    public Patient findByNumDossier(String numDossier) {
        return patientDao.findByNumDossier(numDossier);
    }

    @Override
    @Transactional
    public int deleteByNumDossier(String numDossier) {
        return patientDao.deleteByNumDossier(numDossier);
    }

    @Override
    public List<Patient> findAll() {
        return patientDao.findAll();
    }

    @Override
    public int save(Patient patient) {
        patientDao.save(patient);
        return 1;
    }
}
