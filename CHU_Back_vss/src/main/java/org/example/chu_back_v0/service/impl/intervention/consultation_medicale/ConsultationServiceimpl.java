package org.example.chu_back_v0.service.impl.intervention.consultation_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.example.chu_back_v0.dao.intervention.consultation_medicale.ConsultationDao;
import org.example.chu_back_v0.service.facade.intervention.consultation_medicale.ConsultationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ConsultationServiceimpl implements ConsultationService {
    @Autowired
    private ConsultationDao consultationDao;

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
        consultationDao.save(consultation);
        return 1;
    }
}
