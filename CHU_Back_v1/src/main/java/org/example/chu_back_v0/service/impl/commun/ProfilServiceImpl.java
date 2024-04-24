package org.example.chu_back_v0.service.impl.commun;

import org.example.chu_back_v0.bean.commun.Profil;
import org.example.chu_back_v0.dao.commun.ProfilDao;
import org.example.chu_back_v0.service.facade.commun.ProfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfilServiceImpl implements ProfilService {
    @Autowired
    private ProfilDao profilDao;
    @Override
    public Profil findByRef(String ref) {
        return profilDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return profilDao.deleteByRef(ref);
    }
   @Override
    public List<Profil> findAll() {
        return profilDao.findAll();
    }
   @Override
    public Profil save(Profil profil) {
        return profilDao.save(profil);
    }
}
