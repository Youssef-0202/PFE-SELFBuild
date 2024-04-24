package org.example.chu_back_v0.dao.intervention.consultation_medicale;

import org.example.chu_back_v0.bean.intervention.consultation_medicale.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationDao extends JpaRepository<Consultation, Long> {
    Consultation findByRef(String ref);

    int deleteByRef(String ref);
}
