package org.example.chu_back_v0.service.impl.consultation.consultation_medicale;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.patient.Patient;
import org.example.chu_back_v0.dao.intervention.consultation_medicale.ConsultationDao;
import org.example.chu_back_v0.service.facade.commun.InfermierService;
import org.example.chu_back_v0.service.facade.commun.MedecinService;
import org.example.chu_back_v0.service.facade.commun.ProfilService;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.patient.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultationServiceimpl implements ConsultationService {
    @Autowired
    private ConsultationDao consultationDao;
    @Autowired
    private MedecinService medecinService;
    @Autowired
    private InfermierService infermierService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private ProfilService profilService;

    @Override
    public Consultation findByRef(String ref) {
        return consultationDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return consultationDao.deleteByRef(ref);
    }

    @Override
    public List<Consultation> findAll() {
        return consultationDao.findAll();
    }

    @Override
    public int save(Consultation consultation) {
        Consultation consultation1 = consultationDao.findByRef(consultation.getRef());
        if(consultation1== null){
            if(consultation.getMedcin()!= null && consultation.getMedcin().getRef()!= null ){
                Medecin medecin = medecinService.findByRef(consultation.getMedcin().getRef());
                if(medecin == null) return -2;
                consultation.setMedcin(medecin);
            }else
                consultation.setMedcin(null);

            if(consultation.getInfermier()!= null && consultation.getInfermier().getRef()!= null ){
                Infermier infermier = infermierService.findByRef(consultation.getInfermier().getRef());
                if(infermier == null) return -3;
                consultation.setInfermier(infermier);
            }else
                consultation.setInfermier(null);

            if(consultation.getPatient()!= null && consultation.getPatient().getNumDossier()!= null ){
                Patient patient = patientService.findByNumDossier(consultation.getPatient().getNumDossier());
                if(patient == null) return -4;
                consultation.setPatient(patient);
            }else
                consultation.setPatient(null);

            consultationDao.save(consultation);
            return 1;

        }else {
            return -1;
        }
    }
}
