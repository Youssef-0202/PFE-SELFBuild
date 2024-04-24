package org.example.chu_back_v0.dao.commun;

import org.example.chu_back_v0.bean.commun.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilDao extends JpaRepository<Profil,Long> {
    Profil findByRef(String ref);
    int deleteByRef(String ref);
}
