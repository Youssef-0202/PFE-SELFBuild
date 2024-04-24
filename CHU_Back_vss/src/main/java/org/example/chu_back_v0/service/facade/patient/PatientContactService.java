package org.example.chu_back_v0.service.facade.patient;

import org.example.chu_back_v0.bean.patient.PatientContact;

import java.util.List;

public interface PatientContactService {
    PatientContact findByCin(String cin);

    int deleteByCin(String cin);

    List<PatientContact> findAll();

    int save(PatientContact patientContact);
}
