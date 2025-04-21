package org.example.chu_back_v0.service.facade.intervention.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;

import java.util.List;

public interface SyntheseMedicaleService {
    SyntheseMedicale findByRef(String ref);

    int deleteByRef(String ref);

    List<SyntheseMedicale> findAll();

    int save(SyntheseMedicale syntheseMedicale);
}
