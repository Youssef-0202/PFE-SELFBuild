package org.example.chu_back_v0.service.impl.consultation.dossier_medical;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.dossier_medical.AnalyseMedicale;
import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;
import org.example.chu_back_v0.dao.intervention.consultation_medicale.ConsultationDao;
import org.example.chu_back_v0.dao.intervention.dossier_medical.AnalyseMedicaleDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.AnalyseMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnalyseMedicaleServiceimpl implements AnalyseMedicaleService {
    @Autowired
    private AnalyseMedicaleDao analyseMedicaleDao;

    @Autowired
    private EpreuveServiceimpl EpreuveService;

    @Autowired
    private ConsultationDao consultationDao;

    @Override
    public AnalyseMedicale findByRef(String ref) {
        return analyseMedicaleDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return analyseMedicaleDao.deleteByRef(ref);
    }

    @Override
    public List<AnalyseMedicale> findAll() {
        return analyseMedicaleDao.findAll();
    }

    @Override
    public int save(AnalyseMedicale analyseMedicale) {
        if(analyseMedicaleDao.findByRef(analyseMedicale.getRef())== null){
            if (analyseMedicale.getEpreuve() != null && analyseMedicale.getEpreuve().getRef() != null) {
                String code = analyseMedicale.getEpreuve().getRef();
                Epreuve epreuve = EpreuveService.findByRef(code);
                analyseMedicale.setEpreuve(epreuve);
            } else {
                analyseMedicale.setEpreuve(null);
            }

            if(analyseMedicale.getConsultation() != null && analyseMedicale.getConsultation().getRef()!= null){
                String ref = analyseMedicale.getConsultation().getRef();
                Consultation consultation = consultationDao.findByRef(ref);
                analyseMedicale.setConsultation(consultation);
            }else {
                analyseMedicale.setConsultation(null);
            }
            analyseMedicaleDao.save(analyseMedicale);
            return 1;
        }else
            return -1;
    }
}
