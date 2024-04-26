package org.example.chu_back_v0.service.impl.consultation.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.TraitementDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.MedicamentService;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.TraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TraitementServiceimpl implements TraitementService {
    @Autowired
    TraitementDao traitementDao;
    @Autowired
    ConsultationService consultationService;
    @Autowired
    MedicamentService medicamentService;

    @Override
    public Traitement findByRef(String ref) {
        return traitementDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return traitementDao.deleteByRef(ref);
    }

    @Override
    public List<Traitement> findAll() {
        return traitementDao.findAll();
    }

    @Override
    public int save(Traitement traitement) {
        if(traitement.getRef() == "" || traitement.getRef() == null ){
            return 0 ;
        }
        Traitement tre = traitementDao.findByRef(traitement.getRef());
        if(tre == null){
            if(traitement.getConsultation() != null && traitement.getConsultation().getRef() != null){
                Consultation consultation = consultationService.findByRef(traitement.getConsultation().getRef());
                if(consultation == null ) return -2;
                traitement.setConsultation(consultation);
                traitementDao.save(traitement);
                return 1;
            }
            else{
                traitement.setConsultation(null);
                traitementDao.save(traitement);
                return -3;
            }
        }else {
            return -4;
        }
    }
}
