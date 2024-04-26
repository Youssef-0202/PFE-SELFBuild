package org.example.chu_back_v0.service.impl.commun;

import org.example.chu_back_v0.bean.commun.Medecin;
import org.example.chu_back_v0.bean.commun.Sexe;
import org.example.chu_back_v0.dao.commun.MedecinDao;
import org.example.chu_back_v0.service.facade.commun.MedecinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedecinServiceimpl implements MedecinService {
    @Autowired
    private MedecinDao medecinDao;
    @Autowired
    private SexeServiceimpl sexeService;

    @Override
    public Medecin findByRef(String ref) {
        return medecinDao.findByRef(ref);
    }

    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return medecinDao.deleteByRef(ref);
    }

    @Override
    public List<Medecin> findAll() {
        return medecinDao.findAll();
    }

    @Override
    public int save(Medecin medecin) {
        if(medecin.getRef() == "" || medecin.getRef() == null ){
            return 0 ;
        }
        Medecin med = medecinDao.findByRef(medecin.getRef());
        if (med == null) {
            if (medecin.getSexe() != null && medecin.getSexe().getRef() != null) {
                if (medecin.getSexe().getRef().equals("h") || medecin.getSexe().getRef().equals("f")) {
                    String code = medecin.getSexe().getRef();
                    Sexe sexe = sexeService.findByRef(code);
                    medecin.setSexe(sexe);
                    medecinDao.save(medecin);
                    return 1;
                } else {
                    System.out.println(" h ou f !! ");
                    return -2;
                }
            } else {
                medecin.setSexe(null);
                medecinDao.save(medecin);
                return -3;
            }

        }else {
            return -1;
        }


    }
}
