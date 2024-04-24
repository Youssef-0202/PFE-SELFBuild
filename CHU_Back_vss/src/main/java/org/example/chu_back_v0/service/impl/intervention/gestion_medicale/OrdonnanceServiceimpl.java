package org.example.chu_back_v0.service.impl.intervention.gestion_medicale;

import org.example.chu_back_v0.bean.intervention.gestion_medicale.Ordonnance;
import org.example.chu_back_v0.dao.intervention.gestion_medicale.OrdonnanceDao;
import org.example.chu_back_v0.service.facade.intervention.gestion_medicale.OrdonnanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdonnanceServiceimpl implements OrdonnanceService {
    @Autowired
    OrdonnanceDao ordonnanceDao;

    @Override
    public Ordonnance findByRef(String ref) {
        return ordonnanceDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return ordonnanceDao.deleteByRef(ref);
    }

    @Override
    public List<Ordonnance> findAll() {
        return ordonnanceDao.findAll();
    }

    @Override
    public int save(Ordonnance ordonnance) {
        ordonnanceDao.save(ordonnance);
        return 1;
    }
}
