package org.example.chu_back_v0.dao.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.AnalyseMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseMedicaleDao extends JpaRepository<AnalyseMedicale, Long> {
    AnalyseMedicale findByRef(String ref);

    int deleteByRef(String ref);
}
