package org.example.chu_back_v0.service.facade.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;

import java.util.List;

public interface TraitementService {
    Traitement findByRef(String ref);

    int deleteByRef(String ref);

    List<Traitement> findAll();

    int save(Traitement traitement);
}
