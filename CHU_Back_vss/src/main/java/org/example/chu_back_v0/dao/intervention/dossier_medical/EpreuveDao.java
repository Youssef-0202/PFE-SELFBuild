package org.example.chu_back_v0.dao.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Epreuve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpreuveDao extends JpaRepository<Epreuve, Long> {
    Epreuve findByRef(String ref);
    int deleteByRef(String ref);
}
