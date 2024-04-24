package org.example.chu_back_v0.dao.intervention.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.Radiologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiologieDao extends JpaRepository<Radiologie, Long> {
    Radiologie findByRef(String ref);

    int deleteByRef(String ref);

}
