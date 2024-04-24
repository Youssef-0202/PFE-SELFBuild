package org.example.chu_back_v0.service.facade.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;

import java.util.List;

public interface MedicamentService {
    Medicament findByRef(String ref);

    int deleteByRef(String ref);

    List<Medicament> findAll();

    int save(Medicament medicament);
}
