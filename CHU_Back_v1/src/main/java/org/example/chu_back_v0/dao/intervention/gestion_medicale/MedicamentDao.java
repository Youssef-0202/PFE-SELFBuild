package org.example.chu_back_v0.dao.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentDao extends JpaRepository<Medicament, Long> {
    Medicament findByRef(String ref);

    int deleteByRef(String ref);

}
