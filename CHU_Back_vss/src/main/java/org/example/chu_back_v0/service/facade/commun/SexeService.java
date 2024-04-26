package org.example.chu_back_v0.service.facade.commun;

import org.example.chu_back_v0.bean.commun.Sexe;

import java.util.List;

public interface SexeService {


    Sexe findByRef(String ref);

    int deleteByRef(String ref);

    List<Sexe> findAll();

    int save(Sexe sexe);

    void deleteAll();

    void initSexe();
}
