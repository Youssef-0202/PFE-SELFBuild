package org.example.chu_back_v0.service.impl.consultation.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.rapport_medicaux.Diagnostic;
import org.example.chu_back_v0.dao.intervention.rapport_medicaux.DiagnosticDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.DiagnosticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DiagnosticServiceimpl implements DiagnosticService {
    @Autowired
    DiagnosticDao diagnosticDao;

    @Autowired
    ConsultationService consultationService;

    @Override
    public Diagnostic findByRef(String ref) {
        return diagnosticDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return diagnosticDao.deleteByRef(ref);
    }

    @Override
    public List<Diagnostic> findAll() {
        return diagnosticDao.findAll();
    }

    @Override
    public int save(Diagnostic diagnostic) {
        if(diagnostic.getRef() == "" || diagnostic.getRef() == null ){
            return 0 ;
        }
        Diagnostic diag = diagnosticDao.findByRef(diagnostic.getRef());
        if(diag==null){
            if(diagnostic.getConsultation() != null && diagnostic.getConsultation().getRef() != null){
                Consultation consultation = consultationService.findByRef(diagnostic.getConsultation().getRef());
                if(consultation == null ) return -2;
                diagnostic.setConsultation(consultation);
                diagnosticDao.save(diagnostic);
                return 1;
            }
            else{
                diagnostic.setConsultation(null);
                diagnosticDao.save(diagnostic);
                return -3;
            }
        }else {
            return -4;
        }
    }
}
