package org.example.chu_back_v0.service.facade.intervention.consultation_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;

import java.util.List;

public interface ConsultationService {
    Consultation findByRef(String ref);

    int deleteByRef(String ref);

    List<Consultation> findAll();

    int save(Consultation consultation);
}
