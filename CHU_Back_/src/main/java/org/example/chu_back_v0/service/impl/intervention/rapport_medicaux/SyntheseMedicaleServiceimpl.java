package org.example.chu_back_v0.service.impl.intervention.rapport_medicaux;

import org.example.chu_back_v0.bean.intervention.rapport_medicaux.SyntheseMedicale;
import org.example.chu_back_v0.dao.intervention.rapport_medicaux.SyntheseMedicaleDao;
import org.example.chu_back_v0.service.facade.intervention.rapport_medicaux.SyntheseMedicaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SyntheseMedicaleServiceimpl implements SyntheseMedicaleService {
    @Autowired
    SyntheseMedicaleDao syntheseMedicaleDao;

    @Override
    public SyntheseMedicale findByRef(String ref) {
        return syntheseMedicaleDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return syntheseMedicaleDao.deleteByRef(ref);
    }

    @Override
    public List<SyntheseMedicale> findAll() {
        return syntheseMedicaleDao.findAll();
    }

    @Override
    public int save(SyntheseMedicale syntheseMedicale) {
        syntheseMedicaleDao.save(syntheseMedicale);
        return 1;
    }


}
