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
        if(infermier.getRef() == "" || infermier.getRef() == null ){
            return 0 ;
        }

        Infermier inf = infermierDao.findByRef(infermier.getRef());
        if (inf == null) {
            if (infermier.getSexe() != null && infermier.getSexe().getRef() != null) {
                if (infermier.getSexe().getRef().equals("h") || infermier.getSexe().getRef().equals("f")) {
                    String code = infermier.getSexe().getRef();
                    Sexe sexe = sexeService.findByRef(code);
                    infermier.setSexe(sexe);
                    infermierDao.save(infermier);
                    return 1;
                } else {
                    System.out.println(" f ou h  !! ");
                    return -2;
                }
            } else {
                infermier.setSexe(null);
                infermierDao.save(infermier);
                return -3;
            }
        }else {
            return -1;
        }


    }
}