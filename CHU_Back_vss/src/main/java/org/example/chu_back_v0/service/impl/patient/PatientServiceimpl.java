package org.example.chu_back_v0.service.impl.patient;

import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.bean.patient.Patient;
import org.example.chu_back_v0.bean.patient.PatientContact;
import org.example.chu_back_v0.bean.patient.Relation;
import org.example.chu_back_v0.dao.patient.PatientDao;
import org.example.chu_back_v0.service.facade.commun.SexeService;
import org.example.chu_back_v0.service.facade.patient.PatientContactService;
import org.example.chu_back_v0.service.facade.patient.PatientService;
import org.example.chu_back_v0.service.facade.patient.RelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceimpl implements PatientService {
    @Autowired
    private PatientDao patientDao;

    @Autowired
    private SexeService sexeService;

    @Autowired
    private PatientContactService patientContactService;

    @Autowired
    private RelationService relationService;


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
        if(patient.getNumDossier() == "" || patient.getNumDossier() == null ){
             return 0 ;
        }
        Patient pat = patientDao.findByNumDossier(patient.getNumDossier());
        if(pat == null){
            if(patient.getSexe() != null && patient.getSexe().getRef() != null){
                if (patient.getSexe().getRef().equals("h") || patient.getSexe().getRef().equals("f")) {
                    String code = patient.getSexe().getRef();
                    Sexe sexe = sexeService.findByRef(code);
                    patient.setSexe(sexe);
                } else {
                    System.out.println(" f ou h  !! ");
                    return -2;
                }
            }
            else {
                System.out.println("sexe is null");
                patient.setSexe(null);
            }

            if(patient.getPassionContact() != null && patient.getPassionContact().getCin() != null){
                String cin = patient.getPassionContact().getCin();
                PatientContact patientContact = patientContactService.findByCin(cin);
                patient.setPassionContact(patientContact);
            }
            else {
                System.out.println("passion contact null");
                patient.setPassionContact(null);
            }
            patientDao.save(patient);
            return 1;
        }else {
            return -1;
        }
    }
}
