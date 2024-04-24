package org.example.chu_back_v0.service.facade.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;

import java.util.List;

public interface OrdonnanceService {
    Ordonnance findByRef(String ref);

    int deleteByRef(String ref);

    List<Ordonnance> findAll();

    int save(Ordonnance ordonnance);
}
