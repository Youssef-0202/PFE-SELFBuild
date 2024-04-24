package org.example.chu_back_v0.dao.patient;

import org.apache.catalina.LifecycleState;
import org.example.chu_back_v0.bean.patient.PatientContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PationContactDao extends JpaRepository<PatientContact, Long> {
    PatientContact findByCin(String cin);

    int deleteByCin(String cin);
}
