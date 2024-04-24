package org.example.chu_back_v0.dao.commun;

import org.example.chu_back_v0.bean.commun.Infermier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfermierDao extends JpaRepository<Infermier, Long> {
    Infermier findByRef(String ref);

    int deleteByRef(String ref);
}
