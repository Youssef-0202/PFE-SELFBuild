package org.example.chu_back_v0.service.facade.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;

import java.util.List;

public interface CertificatServive {
    Certificat findByRef(String ref);

    int deleteByRef(String ref);

    List<Certificat> findAll();

    int save(Certificat certificat);
}
