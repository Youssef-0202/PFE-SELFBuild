package org.example.chu_back_v0.dao.commun;

import org.example.chu_back_v0.bean.commun.Sexe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SexeDao extends JpaRepository<Sexe, Long> {
  Sexe findByRef(String ref);
  int deleteByRef(String ref);
}
