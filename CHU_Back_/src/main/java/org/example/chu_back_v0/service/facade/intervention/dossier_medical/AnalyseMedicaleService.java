package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.AnalyseMedicale;

import java.util.List;

public interface AnalyseMedicaleService {
    AnalyseMedicale findByRef(String ref);

    int deleteByRef(String ref);

    List<AnalyseMedicale> findAll();

    int save(AnalyseMedicale analyseMedicale);
}
