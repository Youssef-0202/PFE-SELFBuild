package org.example.chu_back_v0.service.facade.commun;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface InfermierService {
    Infermier findByRef(String ref);

    @Transactional
    int deleteByRef(String ref);

    List<Infermier> findAll();

    int save(Infermier infermier);
}
