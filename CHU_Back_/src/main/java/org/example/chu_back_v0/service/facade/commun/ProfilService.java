package org.example.chu_back_v0.service.facade.commun;

import org.example.chu_back_v0.bean.commun.Profil;

import java.util.List;

public interface ProfilService {
    Profil findByRef(String ref);

    int deleteByRef(String ref);

    List<Profil> findAll();

    Profil save(Profil profil);
}
