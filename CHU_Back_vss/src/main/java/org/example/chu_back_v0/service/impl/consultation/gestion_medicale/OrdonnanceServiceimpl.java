package org.example.chu_back_v0.service.impl.consultation.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.OrdonnanceDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdonnanceServiceimpl implements OrdonnanceService {
    @Autowired
    OrdonnanceDao ordonnanceDao;
    @Autowired
    ConsultationService consultationService;

    @Override
    public Ordonnance findByRef(String ref) {
        return ordonnanceDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return ordonnanceDao.deleteByRef(ref);
    }

    @Override
    public List<Ordonnance> findAll() {
        return ordonnanceDao.findAll();
    }

    @Override
    public int save(Ordonnance ordonnance) {
        if(ordonnance.getRef() == "" || ordonnance.getRef() == null ){
            return 0 ;
        }
        Ordonnance ord = ordonnanceDao.findByRef(ordonnance.getRef());
        if(ord == null){
            if(ordonnance.getConsultation() != null && ordonnance.getConsultation().getRef() != null){
                Consultation consultation = consultationService.findByRef(ordonnance.getConsultation().getRef());
                if(consultation == null ) return -2;
                ordonnance.setConsultation(consultation);
                ordonnanceDao.save(ordonnance);
                return 1;
            }
            else{
                ordonnance.setConsultation(null);
                ordonnanceDao.save(ordonnance);
                return -3;
            }
        }else {
            return -4;
        }
    }
}
