package org.example.chu_back_v0.service.facade.commun;

import org.example.chu_back_v0.bean.commun.Medecin;

import java.util.List;

public interface MedecinService {
    Medecin findByRef(String ref);

    int deleteByRef(String ref);

    List<Medecin> findAll();

    int save(Medecin medecin);
}
