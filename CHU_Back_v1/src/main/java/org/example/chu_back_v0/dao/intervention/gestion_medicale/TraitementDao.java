package org.example.chu_back_v0.dao.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraitementDao extends JpaRepository<Traitement, Long> {
    Traitement findByRef(String ref);

    int deleteByRef(String ref);

}
