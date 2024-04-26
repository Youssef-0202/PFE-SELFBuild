package org.example.chu_back_v0.service.impl.consultation.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;
import org.example.chu_back_v0.dao.intervention.rapport_medicaux.SyntheseMedicaleDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.SyntheseMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SyntheseMedicaleServiceimpl implements SyntheseMedicaleService {
    @Autowired
    SyntheseMedicaleDao syntheseMedicaleDao;

    @Autowired
    ConsultationService consultationService;

    @Override
    public SyntheseMedicale findByRef(String ref) {
        return syntheseMedicaleDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return syntheseMedicaleDao.deleteByRef(ref);
    }

    @Override
    public List<SyntheseMedicale> findAll() {
        return syntheseMedicaleDao.findAll();
    }

    @Override
    public int save(SyntheseMedicale syntheseMedicale) {
        if(syntheseMedicale.getRef() == "" || syntheseMedicale.getRef() == null ){
            return 0 ;
        }

        SyntheseMedicale synthese = syntheseMedicaleDao.findByRef(syntheseMedicale.getRef());
        if(synthese == null ){
            if(syntheseMedicale.getConsultation() != null && syntheseMedicale.getConsultation().getRef() != null  ){
                Consultation consultation =  consultationService.findByRef(syntheseMedicale.getConsultation().getRef());
                if(consultation != null){
                    syntheseMedicale.setConsultation(consultation);
                }else {
                    return -3;
                }
            }
            else {
                syntheseMedicale.setConsultation(null);
                return -2;
            }
            syntheseMedicaleDao.save(syntheseMedicale);
            return 1;
        }else{
            return -1;
        }
    }


}
