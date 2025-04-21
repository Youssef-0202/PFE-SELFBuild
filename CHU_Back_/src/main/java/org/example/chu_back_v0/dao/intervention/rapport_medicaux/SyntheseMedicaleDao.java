package org.example.chu_back_v0.dao.intervention.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SyntheseMedicaleDao extends JpaRepository<SyntheseMedicale, Long> {
    SyntheseMedicale findByRef(String ref);

    int deleteByRef(String ref);

}
