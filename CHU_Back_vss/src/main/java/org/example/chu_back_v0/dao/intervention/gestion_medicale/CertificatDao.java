package org.example.chu_back_v0.dao.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificatDao extends JpaRepository<Certificat, Long> {
    Certificat findByRef(String ref);

    int deleteByRef(String ref);

}
