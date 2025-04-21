package org.example.chu_back_v0.service.impl.commun;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.dao.commun.InfermierDao;
import org.example.chu_back_v0.service.facade.commun.InfermierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InfermierServiceimpl implements InfermierService {
    @Autowired
    private InfermierDao infermierDao;
    @Autowired
    private SexeServiceimpl sexeService;

    @Override
    public Infermier findByRef(String ref) {
        return infermierDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return infermierDao.deleteByRef(ref);
    }

    @Override
    public List<Infermier> findAll() {
        return infermierDao.findAll();
    }

    @Override
    public int save(Infermier infermier) {
        if (infermier.getRef() != null) {
            if (infermier.getSexe() != null && infermier.getSexe().getRef() != null) {
                if (infermier.getSexe().getRef().equals("0") || infermier.getSexe().getRef().equals("1")) {
                    String code = infermier.getSexe().getRef();
                    Sexe sexe = sexeService.findByRef(code);
                    infermier.setSexe(sexe);
                    infermierDao.save(infermier);
                    return 1;
                } else {
                    System.out.println(" 0 ou 1 !! ");
                    return -2;
                }
            } else {
                infermier.setSexe(null);
                infermierDao.save(infermier);
                return -3;
            }


        }
        return -1;

    }
}