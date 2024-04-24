package org.example.chu_back_v0.service.facade.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Antecedent;

import java.util.List;

public interface AntecedentService {
    Antecedent findByRef(String ref);

    int deleteByRef(String ref);

    List<Antecedent> findAll();

    int save(Antecedent antecedent);
}
