package org.example.chu_back_v0.dao.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdonnanceDao extends JpaRepository<Ordonnance, Long> {
    Ordonnance findByRef(String ref);

    int deleteByRef(String ref);
}
