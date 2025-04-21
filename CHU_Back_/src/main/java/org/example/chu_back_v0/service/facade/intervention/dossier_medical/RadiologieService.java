package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Radiologie;

import java.util.List;

public interface RadiologieService {
    Radiologie findByRef(String ref);

    int deleteByRef(String ref);

    List<Radiologie> findAll();

    int save(Radiologie radiologie);
}
