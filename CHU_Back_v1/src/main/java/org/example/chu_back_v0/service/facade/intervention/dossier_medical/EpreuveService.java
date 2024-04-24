package org.example.chu_back_v0.service.facade.intervention.dossier_medical;



import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;

import java.util.List;

public interface EpreuveService {

    Epreuve findByRef(String ref);

    int deleteByRef(String ref);

    List<Epreuve> findAll();

    int save(Epreuve epreuve);
}
