package org.example.chu_back_v0.service.impl.consultation.dossier_medical;

import org.example.chu_back_v0.bean.intervention.dossier_medical.GroupeSanguin;
import org.example.chu_back_v0.dao.intervention.dossier_medical.GroupeSanguinDao;
import org.example.chu_back_v0.service.facade.intervention.dossier_medical.GroupSanguineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GroupeSanguineServiceimpl implements GroupSanguineService {
    @Autowired
    GroupeSanguinDao groupeSanguinDao;
    @Override
    public GroupeSanguin findByRef(String ref) {
        return groupeSanguinDao.findByRef(ref);
    }
    @Override
    @Transactional
    public int deleteByRef(String ref) {
        return groupeSanguinDao.deleteByRef(ref);
    }

    @Override
    public List<GroupeSanguin> findAll() {
        return groupeSanguinDao.findAll();
    }

    @Override
    public int save(GroupeSanguin groupeSanguin) {
        if(groupeSanguin.getRef() == null || groupeSanguin.getRef() ==""){
            return 0;
        }
        if(groupeSanguinDao.findByRef(groupeSanguin.getRef())==null){
            groupeSanguinDao.save(groupeSanguin);
            return 1;
        }
        else
            return -1;
    }
}
