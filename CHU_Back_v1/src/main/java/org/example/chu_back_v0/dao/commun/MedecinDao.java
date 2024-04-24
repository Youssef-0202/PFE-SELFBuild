package org.example.chu_back_v0.dao.commun;

import org.example.chu_back_v0.bean.commun.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinDao extends JpaRepository<Medecin, Long> {
    Medecin findByRef(String ref);

    int deleteByRef(String ref);
}
