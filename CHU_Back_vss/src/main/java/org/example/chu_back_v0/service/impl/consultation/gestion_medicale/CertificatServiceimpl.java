package org.example.chu_back_v0.service.impl.consultation.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.CertificatDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.CertificatServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CertificatServiceimpl implements CertificatServive {
    @Autowired
    private CertificatDao certificatDao;
    @Autowired
    private ConsultationService consultationService;

    @Override
    public Certificat findByRef(String ref) {
        return certificatDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return certificatDao.deleteByRef(ref);
    }

    @Override
    public List<Certificat> findAll() {
        return certificatDao.findAll();
    }

    @Override
    public int save(Certificat certificat) {
        if(certificat.getRef() == "" || certificat.getRef() == null ){
            return 0 ;
        }
        Certificat cert = certificatDao.findByRef(certificat.getRef());
        if(cert == null){
            if(certificat.getConsultation() != null && certificat.getConsultation().getRef() != null){
                Consultation consultation = consultationService.findByRef(certificat.getConsultation().getRef());
                if(consultation == null ) return -2;
                certificat.setConsultation(consultation);
                certificatDao.save(certificat);
                return 1;
            }
            else{
                certificat.setConsultation(null);
                certificatDao.save(certificat);
                return -3;
            }
        }else {
                return -4;
        }
    }
}
