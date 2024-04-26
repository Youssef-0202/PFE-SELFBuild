package org.example.chu_back_v0.service.impl.consultation.dossier_medical;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.dossier_medical.FichePatient;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;
import org.example.chu_back_v0.dao.intervention.dossier_medical.FichePatientDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.AntecedentService;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.FichePatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FichePatientServiceimpl implements FichePatientService {
    @Autowired
    FichePatientDao fichePatientDao;
    @Autowired
    AntecedentService antecedentService;
    @Autowired
    ConsultationService consultationService;

    @Override
    public FichePatient findByRef(String ref) {
        return fichePatientDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return fichePatientDao.deleteByRef(ref);
    }

    @Override
    public List<FichePatient> findAll() {
        return fichePatientDao.findAll();
    }

    @Override
    public int save(FichePatient fichePatient) {
        if(fichePatient.getRef() == null || fichePatient.getRef() == "null")
            return 0;

        FichePatient fichePatient1 = fichePatientDao.findByRef(fichePatient.getRef());
        if(fichePatient1==null){
            if (fichePatient.getAntecedent().getRef() != null && fichePatient.getAntecedent() != null) {
                String ref = fichePatient.getAntecedent().getRef();
                Antecedent antecedent = antecedentService.findByRef(ref);
                fichePatient.setAntecedent(antecedent);
            } else {
                fichePatient.setAntecedent(null);
            }

            if(fichePatient.getConsultation() != null && fichePatient.getConsultation().getRef()!= null){
                String ref = fichePatient.getConsultation().getRef();
                Consultation consultation = consultationService.findByRef(ref);
                fichePatient.setConsultation(consultation);
            }else {
                fichePatient.setConsultation(null);
            }
            fichePatientDao.save(fichePatient);
            return 1;
        }
        else {
            return -1;
        }

    }
}
