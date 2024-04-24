package org.example.chu_back_v0.service.impl.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Certificat;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.CertificatDao;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.CertificatServive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CertificatServiceimpl implements CertificatServive {
    @Autowired
    private CertificatDao certificatDao;

    @Override
    public Certificat findByRef(String ref) {
        return certificatDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return certificatDao.deleteByRef(ref);
    }

    @Override
    public List<Certificat> findAll() {
        return certificatDao.findAll();
    }

    @Override
    public int save(Certificat certificat) {
        certificatDao.save(certificat);
        return 1;
    }
}
