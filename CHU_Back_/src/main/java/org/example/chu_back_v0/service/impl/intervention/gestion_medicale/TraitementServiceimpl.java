package org.example.chu_back_v0.service.impl.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Traitement;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.TraitementDao;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.TraitementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TraitementServiceimpl implements TraitementService {
    @Autowired
    TraitementDao traitementDao;

    @Override
    public Traitement findByRef(String ref) {
        return traitementDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return traitementDao.deleteByRef(ref);
    }

    @Override
    public List<Traitement> findAll() {
        return traitementDao.findAll();
    }

    @Override
    public int save(Traitement traitement) {
        traitementDao.save(traitement);
        return 1;
    }
}
