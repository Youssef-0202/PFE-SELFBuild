package org.example.chu_back_v0.service.impl.commun;

import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.dao.commun.SexeDao;
import org.example.chu_back_v0.service.facade.commun.SexeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SexeServiceimpl implements SexeService {
    @Autowired
    SexeDao sexeDao;

    @Override
    public Sexe findByRef(String ref) {
        return sexeDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return sexeDao.deleteByRef(ref);
    }

    @Override
    public List<Sexe> findAll() {
        return sexeDao.findAll();
    }

    @Override
    public int save(Sexe sexe) {
        sexeDao.save(sexe);
        return 1;
    }

    @Override
    @Transactional
    public void deleteAll() {
        sexeDao.deleteAll();
    }
}
